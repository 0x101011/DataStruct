package DesignMode.SingletonMode.Register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private ContainerSingleton(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();


    public static Object getBean(String classname){
        if (!ioc.containsKey(classname)){
            Object object = null;
            try{
                object = Class.forName(classname).newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }


        return null;
    }
}
