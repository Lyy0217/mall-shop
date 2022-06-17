package com.imooc.learn.juc.singleton;

import java.util.Deque;

/**
 * @author Lyy <liuyangyang03@kuaishou.com>
 * Created on 2022-05-03
 */
public class Singleton7 {

    private enum EnumHolder {
        INSTANCE;
        private Singleton7 instance;

        EnumHolder() {
            this.instance = new Singleton7();
        }

        public Singleton7 getInstance() {
            return instance;
        }
    }

    public static Singleton7 getInstance() {
        //Deque
        return EnumHolder.INSTANCE.getInstance();
    }
}
