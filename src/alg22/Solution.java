package alg22;

import alg2.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb =new StringBuilder();
        List<String> listS=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            sb.append('(');
        }
        for (int i = 0; i < n; i++) {
            sb.append(')');
        }
        String temp =sb.toString();
        listS.add(temp);
        for (int i = n-1; i >0 ; i--) {
            char r =temp.charAt(i);
            for (int j = n; j <2*n-1 ; j++) {
                char t =temp.charAt(j);
                sb.replace(i,i+1,""+t);
                sb.replace(j,j+1,""+r);
                listS.add(sb.toString());
                sb.replace(i,i+1,""+r);
                sb.replace(j,j+1,""+t);
            }
        }
        return listS;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        List<String> st ;
        st=sol.generateParenthesis(4);
        System.out.println(st);

    }
}
