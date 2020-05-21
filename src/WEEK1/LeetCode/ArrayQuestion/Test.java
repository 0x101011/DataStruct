package WEEK1.LeetCode.ArrayQuestion;

public class Test {

    public static void main(String[] args) {
        int x = 1;
        for (show("a");show("b") && x < 4;show("c")) {
            show("d");
            x++;
        }
    }
    public void  solution(){

    }

    public static boolean show(String a){
        System.out.println(a);
        return true;
    }
    /*
    从left: i,j 双循环 O(n^2)
     */
    public int maxArea(int[] a){
        int max = 0;
        for (int i = 0; i < a.length - 1 ; ++i) {
            for (int j = i+1; j < a.length ; ++j) {
                int area = _get(i,j,a);
                max = Math.max(max,area);
            }
        }
        return max;
    }
    public int _get(int a, int b,int[] c){
        return (b-a)*Math.min(c[a],c[b]);
    }

    /*
    从left,right:i,j 单循环左右夹逼O(n)
     */
    public int maxArea2(int[] a){
        int max = 0;
        for (int i = 0,j = a.length - 1; i < j ; ) {
          int minHeight = a[i] < a[j] ? a[i++]:a[j--];
          int area = (j - i + 1) * minHeight;
          max = Math.max(max,area);
        }
        return max;
    }
}
