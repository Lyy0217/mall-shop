package com.imooc.pojo.vo;

import java.util.List;

/**
 * @author Lyy
 * Created on 2020-09-21
 * @desc: 二级分类vo
 */
public class CategoryVO {
    private Long id;
    private String name;
    private Integer type;
    private Long fatherId;
    private List<SubCategoryVO> subCatList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public List<SubCategoryVO> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<SubCategoryVO> subCatList) {
        this.subCatList = subCatList;
    }
}
