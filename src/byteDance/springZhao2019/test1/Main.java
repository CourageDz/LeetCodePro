package byteDance.springZhao2019.test1;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            sc.nextLine();
            for(int i=0;i<n;i++){
                String s=sc.nextLine();
                System.out.println(modifyString(s));
            }
        }
    }

    public static String modifyString(String s){
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        boolean flag=false;
        int count=1;
        int dl=0;
        for(int i=1;i<n;i++){
            char c=s.charAt(i);
            if(c==s.charAt(i-1)){
                count++;
                if(count==2&&flag==false){
                    flag=true;
                }else if(flag==true && count==2){
                    sb.deleteCharAt(i-dl);
                    dl++;
                    flag=false;
                }
                if(count>=3){
                    sb.deleteCharAt(i-dl);
                    dl++;
                }
            }else{
                if(count==1){
                    flag=false;
                    count=1;
                }else {
                    count=1;
                }
            }
        }
        return sb.toString();
    }
}
