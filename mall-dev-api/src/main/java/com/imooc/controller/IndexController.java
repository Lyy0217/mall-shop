package com.imooc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.enums.YseOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.bo.CarouselBO;
import com.imooc.service.CarouselService;
import com.imooc.utils.IMOOCJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel() {
        List<Carousel> result = carouselService.queryAll(YseOrNo.YES.getType());
        return IMOOCJSONResult.ok(result);
    }

    @ApiOperation(value = "保存首页轮播图列表", notes = "保存首页轮播图列表", httpMethod = "POST")
    @PostMapping("/saveCarousel")
    public IMOOCJSONResult saveCarousel(@RequestBody List<CarouselBO> carouselBOS) {
        carouselBOS.forEach(o -> carouselService.saveCarousel(o));
        return IMOOCJSONResult.ok();
    }
}
