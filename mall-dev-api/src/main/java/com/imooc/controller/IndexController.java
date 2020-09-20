package com.imooc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.enums.YseOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.bo.CarouselBO;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.IMOOCJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "首页", tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

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

    /*
     * 首页分类展示需求：
     * 1、第一次刷新主页查询大分类，渲染到主页
     * 2、如果鼠标移到，则加载其字分类内容，如果已经存在子分类，则不需要加载（懒加载）
     */

    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/cats")
    public IMOOCJSONResult cats() {
        List<Category> result = categoryService.queryAllRootLevelService();
        return IMOOCJSONResult.ok(result);
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<CategoryVO> result = categoryService.getSubCatList(rootCatId);
        return IMOOCJSONResult.ok(result);
    }

}
