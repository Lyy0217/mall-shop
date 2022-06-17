package com.imooc.learn.juc.singleton;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2022-05-03
 * 懒汉式+同步方法
 */
public class Singleton3 {

    private static Singleton3 instance = null;

    public static synchronized Singleton3 getInstance() {
        if (null == instance) {
            instance = new Singleton3();
        }
        return instance;
    }
}
