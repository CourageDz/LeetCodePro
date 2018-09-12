package alg7;

import alg6.Solution2;

import java.util.Scanner;

public class Solution {
    public int reverse(int x) {
        int remainder=0,lastremainder=0;
        boolean symbol=true;
        int temp=x;
        while(temp!=0){
            remainder=temp%10;
            temp=temp/10;
            if(lastremainder>Integer.MAX_VALUE/10||(lastremainder==Integer.MAX_VALUE/10 && remainder>7))
                return 0;
            if(lastremainder<Integer.MIN_VALUE/10||(lastremainder==Integer.MIN_VALUE/10 && remainder<-8))
                return 0;
            lastremainder=lastremainder*10+remainder;
        }
        return lastremainder;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num =sc.nextInt();
        Solution sol =new Solution();
        int reversNum=sol.reverse(num);
        System.out.println(reversNum);
        double max=-1*Math.pow(2,31);
        int chushu =(int)max%10;
        System.out.println(chushu);

    }
}
