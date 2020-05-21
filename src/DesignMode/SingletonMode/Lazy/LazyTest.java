package DesignMode.SingletonMode.Lazy;

public class LazyTest {
    public static void main(String[] args) {
        //   LazySimpleSingleton.getInstance();
//创建两个Single实例
//两个线程同时进入，thread未出方法区同时覆盖，一样。出方法区，不一样
//两个线程前后进入，一样
       Thread t1 = new Thread(new ExectorThread());
       Thread t2 = new Thread(new ExectorThread());
       t1.start();
       t2.start();
       System.out.println("Exc End");
    }
//加Syn ，后续线程状态会变成monitor等待running线程运行。
}
