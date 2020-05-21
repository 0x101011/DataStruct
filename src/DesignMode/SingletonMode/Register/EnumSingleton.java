package DesignMode.SingletonMode.Register;

public enum  EnumSingleton {
    INSTANCE;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
    //从JDK层面不被序列化和反射破坏保驾护航。


}
