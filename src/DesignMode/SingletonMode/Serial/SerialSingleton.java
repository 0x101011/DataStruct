package DesignMode.SingletonMode.Serial;

import java.io.Serializable;

//反序列化导致单例破坏
public class SerialSingleton implements Serializable {
    public static final SerialSingleton ss = new SerialSingleton();
    private SerialSingleton(){}

    public static SerialSingleton getInstance(){
        return ss;
    }
    //使用这个方法可以阻止序列化被破坏单例
//    private Object readResolve() {
//        return ss;
//    }
}
