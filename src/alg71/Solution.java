package alg71;

import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        stack.offer("/");
        for (String s : dirs) {
            if (s.equals(""))
                continue;
            else {
                if (s.equals("..") && !stack.peekLast().equals("/"))
                    stack.pollLast();
                else if (!s.equals(".") && !s.equals("..")) {
                    stack.offer(s);
                }
            }
        }
        if (stack.size() > 1) {
            StringBuilder sb = new StringBuilder();
            stack.pollFirst();
            int k = stack.size();
            for (int i = k - 1; i >= 0; i--) {
                sb.append("/");
                sb.append(stack.pollFirst());
            }
            return sb.toString();
        } else
            return stack.pollFirst();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "/a/./b/../..";
        String result = sol.simplifyPath(s);
        System.out.println(result);
    }
}
