package Tree;

public class PlusTest {
    public void test(){
        int a = 1 ;
        int b = 2 ;
        int sum = a + b ;
    }
    public void test1(){
        int i = 0 ;
        int j = i++ ;
        System.out.println( "_"+ i +"_"+j);
    }
    public void test2(){
        int i = 0 ;
        int j = ++i;
        System.out.println("_"+ i +"_" + j);
    }
    public void test3(){
        int i = 0;
        int j = i++ + i++;
        System.out.println( "_"+ i +"_"+j);
    }

    public void test4(){
        int i = 0;
        /*
         * ++ -- 操作符本身就具有很高的优先级（仅次于括号），
         * 因此，这里有无括号，结果是一样的，
         * 可化简为：int j = 5 - ++i + ++i;
         */
        int t = ++i;
        int b = ++i;
        int g = t + b;
        int j = 5 - (++i) + (++i);
        System.out.println("i:" + "_" + i + "_"+"j"+j);
    }

    public void test6(){
        int a = 0;
        int b = 0;
        for (int i = 0; i < 99; i++) {
            a = a++;
            b = a++;
        }
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
//        PlusTest instance = new PlusTest();
//        instance.test4();
//        instance.test6();
      int a = 0 ;
      for ( int i = 0 ; i < 99 ; i++,a++){
            a = a++;
            System.out.println("_a:" + a);
      }
      System.out.println("result:"+ a);

    }

}
