package DesignMode.SingletonMode.ThreadLocal;
//线程内安全，生成均为一个对象。
//跨线程不安全，生成其他对象。
//注册式单例容器取值

//ThreadLocal多数据源动态切换
//数据源路由
public class ThreadLocalSingleton {
    private ThreadLocalSingleton(){}
    public static ThreadLocalSingleton getInstance(){
        return threadInstance.get();
    }
    private static final ThreadLocal<ThreadLocalSingleton> threadInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };


}
