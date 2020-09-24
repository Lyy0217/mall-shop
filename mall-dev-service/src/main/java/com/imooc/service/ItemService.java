package com.imooc.service;

import java.util.List;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.bo.CarouselBO;

/**
 * @author Lyy
 * Created on 2020-09-16
 */
public interface ItemService {

    /**
     * 根据商品id查询商品详情
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格列表
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     */
    ItemsParam queryItemParam(String itemId);
}
