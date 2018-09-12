package alg8;

import java.util.Scanner;

public class Solution {
    public int myAtoi(String str) {
        int num=0;
        boolean symbol=true;
        for(char c:str.toCharArray()){
            if(c==' ') {
                if (num != 0) {
                    if(symbol)
                        return num;
                    else
                        return -1*num;
                }
                continue;
            }
            if(c=='-'){
                symbol=false;
                if(num!=0)
                    return -1*num;
                continue;
            }
            if(c=='+'){
                if(num==0)
                    continue;
                else
                    return num;
            }
            if(!(c>='0'&& c<='9')){
                if (num != 0) {
                    if(symbol)
                        return num;
                    else
                        return -1*num;
                }
                return 0;
            }


            if(c>='0'&&c<='9'){
                int temp=c-'0';
                if(num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&temp>7)){
                    if(!symbol&&(num>Integer.MAX_VALUE/10||(num==Integer.MAX_VALUE/10&&temp>8)))
                        return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                num=num*10+temp;
            }
        }
        if(!symbol)
            return -1*num;
        return num;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s =sc.nextLine();
        Solution sol =new Solution();
        int num=sol.myAtoi(s);
        System.out.println(num);
    }
}

