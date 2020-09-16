package com.imooc.enums;

/**
 * @author Lyy
 * Created on 2020-08-07
 */
public enum YseOrNo {
    NO(0, "否"),
    YES(1, "是"),
    ;

    private final Integer type;
    private final String value;

    YseOrNo(Integer type, String value) {
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
