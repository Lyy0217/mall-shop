package com.imooc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.service.StuService;
import com.imooc.service.UserService;
import com.imooc.utils.IMOOCJSONResult;

@RestController
@RequestMapping("passport")
public class PassPortController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExit")
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

}
