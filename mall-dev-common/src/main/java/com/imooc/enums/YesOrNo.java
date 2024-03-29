package com.imooc.enums;

/**
 * @author Lyy
 * Created on 2020-08-07
 */
public enum YesOrNo {
    NO(0, "否"),
    YES(1, "是"),
    ;

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
