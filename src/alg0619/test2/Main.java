package alg0619.test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String  s=sc.nextLine();
        System.out.println(getMinNumberOfHwc(s));
    }

    private static int getMinNumberOfHwc(String s) {
        char[] chars=s.toCharArray();
        Map<Character,Integer> cMap=new HashMap<>();
        for (int i = 0; i <chars.length ; i++) {
            cMap.put(chars[i],cMap.getOrDefault(chars[i],0)+1);
        }
        int count=0;
        for (Map.Entry entry:cMap.entrySet()) {
            int keyNum=(Integer) entry.getValue();
            count+=keyNum%2;
        }
        return count;
    }
}
