package com.imooc.service;

import java.util.List;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.bo.CarouselBO;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;

/**
 * @author Lyy
 * Created on 2020-09-16
 */
public interface CategoryService {

    /**
     * 查询所有一级分类
     */
    List<Category> queryAllRootLevelService();

    /**
     * @desc: 根据一级分类id，查询子分类信息
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * @desc: 查询首页每个一级分类下的6条最新商品
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
