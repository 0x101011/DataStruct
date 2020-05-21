package DesignMode.SingletonMode.Lazy;

//外部调用的时候初始化
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazySimpleSingleton = null;
    private LazySimpleSingleton(){};

    //JDK 1.6 之后对 synchronized 关键字实现进行性能优化。
    //但是不可避免存在性能问题。
    //syn修饰会导致整个类的内容被Lock
    public synchronized static LazySimpleSingleton getInstance(){
         if (lazySimpleSingleton == null){
            lazySimpleSingleton = new LazySimpleSingleton();
         }
         return lazySimpleSingleton;
    }
    //加 synchronized
}
