package com.imooc.enums;

/**
 * @author Lyy
 * Created on 2020-09-21
 */
public enum CateType {
    ROOT_CATEGORY(1, "一级分类"),
    SECOND_CATEGORY(2, "二级分类"),
    THIRD_CATEGORY(3, "三级分类"),
    ;

    private final int value;
    private final String name;


    CateType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
