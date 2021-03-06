package DesignMode.SingletonMode.Lazy;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
      try {

          //调用者不用普通方式调用，破坏单例。
        Class<?> clazz = LazyInnerClassSingleton.class;

        Constructor<?> c =  clazz.getConstructor();

        c.setAccessible(true);

        Object o1 = c.newInstance();
        Object o2 =LazyInnerClassSingleton.getInstance();

        System.out.println(o1 == o2);

      } catch (Exception e ) {

          e.printStackTrace();

      }



    }
}
