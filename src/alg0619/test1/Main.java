package alg0619.test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(getMaxOuChuanLength(s));
    }

    private static int getMaxOuChuanLength(String s) {
        int n=s.length();
        for (int i = n-2; i >=0 ; i--) {
            if(s.charAt(i)==s.charAt(i/2)){
                if(i%2==0){
                    continue;
                }
                int t=i/2;
                boolean flag=true;
                for (int j = i; j >i/2;j--) {
                    if(s.charAt(t)!=s.charAt(j)){
                        flag=false;
                        break;
                    }else {
                        t--;
                    }
                }
                if(flag){
                    return i+1;
                }
            }
        }
        return 0;
    }
}
