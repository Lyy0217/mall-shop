package com.imooc.learn.juc.singleton;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2022-05-03
 * 懒汉式单例模式
 */
public final class Singleton2 {

    public Singleton2() {
    }

    private static Singleton2 instance = null;

    public static Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
