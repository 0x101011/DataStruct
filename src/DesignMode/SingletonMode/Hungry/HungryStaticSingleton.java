package DesignMode.SingletonMode.Hungry;
//
//首次加载创建实例
//浪费内存空间

public class HungryStaticSingleton {
    private static final HungryStaticSingleton hs ;

    static {
        hs = new HungryStaticSingleton();
    }
    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){
        return  hs;
    }

}
