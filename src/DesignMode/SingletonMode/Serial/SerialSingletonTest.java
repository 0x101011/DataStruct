package DesignMode.SingletonMode.Serial;

import java.io.*;

public class SerialSingletonTest {

    public static void main(String[] args) throws FileNotFoundException {
        SerialSingleton s1 = null;
        SerialSingleton s2 = SerialSingleton.getInstance();

        FileOutputStream tos = null;

        try {
            tos = new FileOutputStream("SerialSingleton.obj");

            ObjectOutputStream oos = new ObjectOutputStream(tos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerialSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SerialSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return;
        }

    }

}
