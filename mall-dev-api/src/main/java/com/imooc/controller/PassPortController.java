package com.imooc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.MD5Utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassPortController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExit(@RequestParam String username) {

        //1. 判断用户名是否为空
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        //2. 判断用户名是否存在
        boolean isExit = userService.queryUsernameIsExit(username);
        if (isExit) {
            return IMOOCJSONResult.errorMsg("用户名空已存在");
        }

        //3. 请求成功，用户名没有重复
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBO userBO,
            HttpServletRequest request,
            HttpServletResponse response) {

        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 判断用户名和密码不能为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 查询用户名是否存在
        boolean isExit = userService.queryUsernameIsExit(username);
        if (isExit) {
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }

        // 2. 密码长度不能少于6位
        if (password.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码长度不能少于6位");
        }

        // 3. 判断两次密码是否一致
        if (!password.equals(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("两次密码输入不一致");
        }

        // 4. 实现注册
        Users result = userService.createUser(userBO);

        setNullProperty(result);

        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(result), true);

        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody UserBO userBO,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 0. 判断用户名和密码不能为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 实现登录
        Users result = userService.queryUsersForLogin(username,
                MD5Utils.getMD5Str(password));

        if (result == null) {
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }

        setNullProperty(result);

        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(result), true);

        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return IMOOCJSONResult.ok(result);
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public IMOOCJSONResult logout(@RequestParam String userId,
            HttpServletRequest request,
            HttpServletResponse response) {

        // 清楚用户相关的cookie信息
        CookieUtils.deleteCookie(request, response, "user");

        // TODO 用户退出登录，需要清空购物车
        // TODO 分布式会话中需要清楚用户数据

        return IMOOCJSONResult.ok();
    }

    private void setNullProperty(Users users) {
        users.setPassword(null);
        users.setMobile(null);
        users.setEmail(null);
        users.setCreatedTime(null);
        users.setUpdatedTime(null);
        users.setBirthday(null);
    }

}
