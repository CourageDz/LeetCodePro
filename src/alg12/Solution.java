package alg12;

import java.util.Scanner;

public class Solution {
    //简单方法：列出所有对应的数与字母数组，如果num》最大的数值，则减去一个该数值，字符串添加一个该字符
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        int x=num/1000;
         num=num%1000;
        for (int i = 0; i <x ; i++) {
            sb.append('M');
        }
        x=num/100;
        num=num%100;
        if(x==9){
            sb.append("CM");
        }else if(x==4){
            sb.append("CD");
        }else if(x/5==1){
            sb.append('D');
            x=x%5;
            for (int i = 0; i <x ; i++) {
                sb.append('C');
            }
        }else{
            for (int i = 0; i < x; i++) {
                sb.append('C');
            }
        }
        x=num/10;
        num=num%10;
        if(x==9){
            sb.append("XC");
        }else if(x==4){
            sb.append("XL");
        }else if(x/5==1){
            sb.append('L');
            x=x%5;
            for (int i = 0; i <x ; i++) {
                sb.append('X');
            }
        }else{
            for (int i = 0; i < x; i++) {
                sb.append('X');
            }
        }
        x=num;
        if(x==9){
            sb.append("IX");
        }else if(x==4){
            sb.append("IV");
        }else if(x/5==1){
            sb.append('V');
            x=x%5;
            for (int i = 0; i <x ; i++) {
                sb.append('I');
            }
        }else{
            for (int i = 0; i < x; i++) {
                sb.append('I');
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num =sc.nextInt();
        Solution sol =new Solution();
        String s=sol.intToRoman(num);
        System.out.println(s);
    }
}
