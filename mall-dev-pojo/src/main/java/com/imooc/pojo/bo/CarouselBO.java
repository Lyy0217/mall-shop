package com.imooc.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Lyy
 * Created on 2020-09-17
 */
@ApiModel(value = "轮播图BO", description = "从客户端，由用户传入的数据封装在此entity中")
public class CarouselBO {
    @ApiModelProperty(value = "主键id", name = "id", example = "", required = true)
    private String id;
    @ApiModelProperty(value = "图片 图片地址", name = "imageUrl", example = "", required = true)
    private String imageUrl;
    @ApiModelProperty(value = "背景色 背景颜色", name = "backgroundColor", example = "", required = true)
    private String backgroundColor;
    @ApiModelProperty(value = "商品id 商品id", name = "itemId", example = "", required = true)
    private String itemId;
    @ApiModelProperty(value = "商品分类id 商品分类id", name = "catId", example = "", required = true)
    private String catId;
    @ApiModelProperty(value = "轮播图类型 轮播图类型", name = "type", example = "", required = true)
    private Integer type;
    @ApiModelProperty(value = "轮播图展示顺序", name = "sort", example = "", required = true)
    private Integer sort;
    @ApiModelProperty(value = "是否展示", name = "isShow", example = "", required = true)
    private Integer isShow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
}
