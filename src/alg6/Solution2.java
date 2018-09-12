package alg6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public String convert(String s, int numRows) {
        int n=s.length();
        if(numRows==1) return s;
        List<StringBuilder> rows =new ArrayList();
        for (int i = 0; i <Math.min(numRows,s.length()) ; i++) {
            rows.add(new StringBuilder());
        }
        int indexRow=0;
        boolean dire=false;
        for(char c:s.toCharArray()){
            rows.get(indexRow).append(c);
            if(indexRow==0||indexRow==numRows-1) {
                dire = !dire;
            }
            indexRow +=dire ? 1 : -1;
        }
        StringBuilder conS= new StringBuilder();
        for (StringBuilder sb: rows) {
            conS.append(sb);
        }
        return conS.toString();
    }


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String s =sc.nextLine();
        int num =sc.nextInt();
        Solution2 sol =new Solution2();
        String ss=sol.convert(s,num);
        System.out.println(ss);
    }
}
