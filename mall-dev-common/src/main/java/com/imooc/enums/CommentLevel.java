package com.imooc.enums;

/**
 * @author Lyy
 * Created on 2020-08-07
 */
public enum CommentLevel {
    GOOD(1, "好评"),
    NORMAL(2, "中评"),
    BAD(3, "差评"),
    ;

    private final Integer type;
    private final String value;

    CommentLevel(Integer type, String value) {
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
