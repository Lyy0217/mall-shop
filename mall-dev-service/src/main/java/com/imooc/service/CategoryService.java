package com.imooc.service;

import java.util.List;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.bo.CarouselBO;
import com.imooc.pojo.vo.CategoryVO;

/**
 * @author Lyy
 * Created on 2020-09-16
 */
public interface CategoryService {

    /**
     * 查询所有一级分类
     */
    List<Category> queryAllRootLevelService();

    List<CategoryVO> getSubCatList(Integer rootCatId);
}
