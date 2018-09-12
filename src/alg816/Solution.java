package alg816;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<String> ambiguousCoordinates(String S) {
        List<String> amC=new ArrayList<>();
        String S1=S.substring(1,S.length()-1);
        for (int i = 1; i <S1.length() ; i++) {
            String s1=S1.substring(0,i);
            String s2=S1.substring(i,S1.length());
            List<String> s1Nums=stringParseTONums(s1);
            List<String> s2Nums=stringParseTONums(s2);
            if(s1Nums.size()!=0){
                for (int j = 0; j <s1Nums.size() ; j++) {
                    StringBuffer sb=new StringBuffer();
                    sb.append('(');
                    sb.append(s1Nums.get(j));
                    if(s2Nums.size()!=0){
                        sb.append(',');
                        for (int k = 0; k <s2Nums.size() ; k++) {
                            StringBuffer sb2=new StringBuffer();
                            sb2.append(' ');
                            sb2.append(s2Nums.get(k));
                            sb2.append(')');
                            amC.add(sb.toString()+sb2.toString());
                        }
                    }
                }
            }
        }
        return amC;
    }
    public List<String> stringParseTONums(String s) {
        List<String> sNums = new ArrayList<>();
        int n = s.length();
        if (n == 1) {
            sNums.add(s);
            return sNums;
        }
        StringBuffer sb = new StringBuffer();
        if (s.charAt(0) == '0') {
            for (int i = 0; i < n; i++) {
                sb.append('0');
            }
            if (s.equals(sb.toString()) || s.charAt(n-1)=='0')
                return sNums;
            else {
                sb.delete(0, n);
                for (int i = 0; i < n; i++) {
                    sb.append(s.charAt(i));
                }
                sb.insert(1, '.');
            }
            sNums.add(sb.toString());
        } else {
            for (int i = 0; i < n; i++) {
                sb.append(s.charAt(i));
            }
            sNums.add(sb.toString());
            if(s.charAt(n-1)!='0'){
                for (int i = 1; i < n; i++) {
                    sb.insert(i, '.');
                    sNums.add(sb.toString());
                    sb.deleteCharAt(i);
                }
            }
        }
        return sNums;
    }
    public List<String> make(String S, int i, int j) {
        // Make on S.substring(i, j)
        List<String> ans = new ArrayList();
        for (int d = 1; d <= j-i; ++d) {
            String left = S.substring(i, i+d);
            String right = S.substring(i+d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0"))
                ans.add(left + (d < j-i ? "." : "") + right);
        }
        return ans;
    }
    public static void main (String[] args) {
        Solution sol =new Solution();
        String s="(0010)";
        List<String> amC= sol.ambiguousCoordinates(s);
        for (int i = 0; i <amC.size() ; i++) {
            System.out.println(amC.get(i));
        }
    }
}
