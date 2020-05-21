package DesignMode.SingletonMode.Lazy;

//全程没有用到syn,性能高
//性能最优
//需要：执行内部类的执行逻辑
public class LazyInnerClassSingleton {
    //虽然构造方法私有
    //但是无法逃避反射攻击。
    private LazyInnerClassSingleton(){
        //下面是可以防止反射。
//        if (LazyHolder.Lazy != null) {
//            throw new RuntimeException("No admit to new more instance")
//        }
    }

    //懒汉的懒汉inner
    //LazyHolder里面的逻辑需要等到外部调用，才执行。
    //巧妙运用内部类特性
    //Jvm底层执行逻辑完美避免了，线程安全问题。
    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.Lazy;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton Lazy = new LazyInnerClassSingleton();
    }

}
