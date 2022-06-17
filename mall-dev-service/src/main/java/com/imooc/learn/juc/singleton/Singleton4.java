package com.imooc.learn.juc.singleton;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2022-05-03
 * double check
 */
public class Singleton4 {

    private volatile static Singleton4 instance = null; // 禁止指令重排序

    public static Singleton4 getInstance() {
        if (null == instance) {
            synchronized (Singleton4.class) {
                if (null == instance) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
