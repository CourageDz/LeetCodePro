package alg17;

import java.util.*;

public class Solution2 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> letter =new LinkedList<>();//ArrayList()无法一直剔除第一项，只能通过索引来删除。
        int n=digits.length();
        if(n==0) return letter;
        letter.add("");

        Map<Integer ,String> keyMap=new HashMap<>();
        int a='a';
        int b='b';
        int c='c';
        for (int i = 2; i <9 ; i++) {
            if(i==6)
                continue;
            StringBuilder sb=new StringBuilder();
            sb.append((char)a);
            sb.append((char)b);
            sb.append((char)c);
            keyMap.put(i,sb.toString());
            a+=3;
            b+=3;
            c+=3;
        }
        keyMap.put(6,"pqrs");
        keyMap.put(9,"wxyz");


        for (int i = 0; i <n ; i++) {

            int size =letter.size();
            for (int j = 0; j <size ; j++) {
                String temp=letter.poll();

                int pos=digits.charAt(i)-'0';
                for (int k = 0; k <keyMap.get(pos).length() ; k++) {
                    letter.add(temp+keyMap.get(pos).charAt(k));
                }
            }
        }
        return letter;
    }
    public static void main(String[] args) {
        Solution2 sol =new Solution2();
        List<String> result=sol.letterCombinations("6");
        System.out.println(result);
    }
}
