package WEEK1.LeetCode.ArrayQuestion;

import javax.sound.midi.SoundbankResource;

public class TwoPointerMethod {


    public static void main(String[] args) {
        TwoPointerMethod instance = new TwoPointerMethod();
        int[] arr = new int[]{1,2,3,14};
        int result = instance.solution(arr);
        System.out.println("result = " + result);
    }
    void twoPointer(int[] a){
        int i= 0,j = 0 ;
        int result = 0;
        while (i<j) {
            if (a[i] + a[j] == result){
                System.out.println(i+"___"+j);
            } else if (a[i] + a[j] < result){
                i++;
            } else {
                j--;
            }

        }
    }

        int solution(int[] arr) {
            int i=0;
            int j=arr.length-1;
            int count=0;
            while(i<=j){
                int tempI = Math.abs(arr[i]);
                int tempJ = Math.abs(arr[j]);
                if(tempI > tempJ) {
                    count++;
                    while(i<=j && Math.abs(arr[i])==tempI) {
                        i++;
                    }
                }else if(tempI < tempJ) {
                    count++;
                    while(i<=j && Math.abs(arr[j])== tempJ) {
                        j--;
                    }
                }else{
                    count++;
                    while(i<=j && Math.abs(arr[i])==tempI) {
                        i++;
                    }
                    while(i<=j && Math.abs(arr[j])== tempJ) {
                        j--;
                    }
                }
            }
            return count;
        }




}
