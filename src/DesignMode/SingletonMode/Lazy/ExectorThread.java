package DesignMode.SingletonMode.Lazy;

import DesignMode.SingletonMode.ThreadLocal.ThreadLocalSingleton;

//不用线程池，就用两个线程来演示全过程
public class ExectorThread implements Runnable {
    @Override
    public void run() {
        //LazySimpleSingleton simpleSingleton = LazySimpleSingleton.getInstance();
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);

    }
}
