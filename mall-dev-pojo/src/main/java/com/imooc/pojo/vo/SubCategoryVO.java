package com.imooc.pojo.vo;

import java.util.List;

/**
 * @author Lyy
 * Created on 2020-09-21
 * @desc: 二级分类vo
 */
public class SubCategoryVO {
    private Long subId;
    private String subName;
    private Integer subType;
    private Long subFatherId;

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Long getSubFatherId() {
        return subFatherId;
    }

    public void setSubFatherId(Long subFatherId) {
        this.subFatherId = subFatherId;
    }
}
