package alg22;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs(res, "", n, 0, 0);
        return res;
    }
    public void dfs(List<String> res, String temp, int n, int left, int right) {
        if(right == n) {
            res.add(temp);
            return;
        }
        if (left < n) dfs(res, temp+"(", n, left+1, right);
        if (right < left) dfs(res, temp+")", n, left, right+1);
    }
    public static void main(String[] args) {
        Solution2 sol =new Solution2();
        List<String> st ;
        st=sol.generateParenthesis(4);
        System.out.println(st);

    }
}
