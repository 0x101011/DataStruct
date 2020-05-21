package DesignMode.SingletonMode.Lazy;

public class ExectorThread2 implements Runnable {
    @Override
    public void run() {
       LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
       System.out.println(Thread.currentThread().getName() + ":" + singleton);

    }
}
