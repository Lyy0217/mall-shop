package com.imooc.learn.juc.singleton;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2022-05-03
 * 枚举,没有懒加载，如果静态方法被调用，则实例被初始化
 */
public enum Singleton6 {
    INSTANCE(1, "instacn1");

    private int value;
    private String desc;

    Singleton6(int value, String desc) {
        this.value = value;
        this.desc = desc;
        System.out.println("init class !!!");
    }

    Singleton6() {
        System.out.println("init class !!!");
    }

    public static void method() {
        System.out.println("hello world!!!");
    }

    public static Singleton6 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        //getInstance();

        method();
    }
}
