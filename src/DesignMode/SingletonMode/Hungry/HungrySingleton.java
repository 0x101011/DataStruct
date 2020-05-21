package DesignMode.SingletonMode.Hungry;

public class HungrySingleton {
    private static final HungrySingleton hs = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return  hs;
    }

}
