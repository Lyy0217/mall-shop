package com.imooc.learn.juc.singleton;

import java.util.Deque;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2022-05-03
 * 饿汉式单例模式,不能被继承
 */
public final class Singleton1 {

    public Singleton1() {
    }

    private static Singleton1 instance = new Singleton1();

    public Singleton1 getInstance() {
        //Deque
        return instance;
    }
}
