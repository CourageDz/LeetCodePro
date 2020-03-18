package alg678;


import java.util.Stack;

public class Solution {
    // time limit exceeded
    Stack<Character> stack = new Stack();
    boolean result = false;

    public boolean checkValidString(String s) {
        int n = s.length();
        boolean result = dfs(s, 0, n);
        return result;
    }

    public boolean dfs(String s, int i, int n) {
        if (i == n) {
            if (stack.isEmpty())
                return true;
            else
                return false;
        }
        if (s.charAt(i) == '*') {
            stack.push('(');
            boolean result1 = dfs(s, i + 1, n);
            stack.pop();

            boolean result2 = false;
            if (!stack.isEmpty()) {
                stack.pop();
                result2 = dfs(s, i + 1, n);
                stack.push('(');
            }

            boolean result3 = dfs(s, i + 1, n);

            result = result || result1 || result2 || result3;
        } else if (s.charAt(i) == '(') {
            stack.push('(');
            boolean result4 = dfs(s, i + 1, n);
            result = result || result4;
            stack.pop();
        } else {
            if (stack.isEmpty())
                return false;
            stack.pop();
            boolean result5 = dfs(s, i + 1, n);
            result = result || result5;
            stack.push('(');
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String S = "(***)";
        boolean result = sol.checkValidString(S);
        System.out.println(result);
    }
}
