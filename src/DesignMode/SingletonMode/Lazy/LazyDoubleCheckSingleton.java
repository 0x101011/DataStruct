package DesignMode.SingletonMode.Lazy;

public class LazyDoubleCheckSingleton {

    private static volatile LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
    private LazyDoubleCheckSingleton(){}

    //JDK 1.6 之后对 synchronized 关键字实现进行性能优化。
    //但是不可避免存在性能问题。
    //syn修饰会导致整个类的内容被Lock


    //双锁适中的方案，先让其他进程能够进入类内方法区。
    public static LazyDoubleCheckSingleton getInstance(){
        //锁1
        if (lazyDoubleCheckSingleton == null){
            synchronized (LazyDoubleCheckSingleton.class) {
                //锁2
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //Cpu执行时转换JVM指令执行
                    //  以下顺寻 2 3 会乱序执行  --- volatile 指令重排序问题
                    //1、分配内存给对象
                    //2、初始化对象
                    //3、将初始化对象和内存地址建立关联,赋值
                    //4、用户初次访问
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
