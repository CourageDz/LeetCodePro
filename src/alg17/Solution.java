package alg17;

import java.util.*;

public class Solution {
    //递归
    public List<String> letterCombinations(String digits) {
        List<String> letter=new ArrayList<>();
        int n=digits.length();
        Map<Integer ,String> keyMap=new HashMap<>();
        keyMap.put(2,"abc");
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
        if(digits.length()==0){
            return letter;
        }

        letter.add("");
        for (int i = 0; i <n ; i++) {
            letter=combine(keyMap.get(digits.charAt(i)-'0'),letter);
        }

        return letter;
    }
    public  List<String> combine(String s,List<String> list){
        List<String> letter =new ArrayList<>();
        for (int i = 0; i <s.length() ; i++) {
            for(String  word :list){
                letter.add(word+s.charAt(i));
            }
        }
        return letter;

    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        List<String> result=sol.letterCombinations("23");
        System.out.println(result);
    }
}
