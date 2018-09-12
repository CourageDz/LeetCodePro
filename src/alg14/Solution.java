package alg14;


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if(strs.length==1){
            return strs[0];
        }
        int n=strs[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <strs.length ; j++) {
                if(i>strs[j].length() || strs[j].charAt(i)!=strs[0].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
