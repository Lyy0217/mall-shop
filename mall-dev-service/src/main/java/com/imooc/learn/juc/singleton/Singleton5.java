package com.imooc.learn.juc.singleton;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2022-05-03
 * holder方式，最好的方式之一
 */
public class Singleton5 {

    private static class Holder {
        private static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return Holder.instance;
    }
}
