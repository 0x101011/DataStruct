package String.StringBuffer;

public class StringBuffer {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer();
        a.test();
    }

    public void test(){
        java.lang.StringBuffer stringBuffer1 = new java.lang.StringBuffer("A");
        boolean f = stringBuffer1.equals(new java.lang.StringBuffer("A"));
        System.out.println(f);
    }
}
