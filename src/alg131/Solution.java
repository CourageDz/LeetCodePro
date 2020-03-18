package alg131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //DFS
    List<List<String>> topList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> stringList = new ArrayList<>();
        dfs(s, 0, 0, stringList);
        return topList;
    }

    public void dfs(String s, int k, int index, List<String> list) {
        if (k == s.length()) {
            List<String> copy = new ArrayList<>(list);
            topList.add(copy);
        } else {
            for (int j = k + 1; j <= s.length(); j++) {
                String sub = s.substring(k, j);
                if (isPalindrome(sub)) {
                    list.add(index, sub);
                    if (j <= s.length())
                        dfs(s, j, index + 1, list);
                    list.remove(index);
                }
            }
        }
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "cbbbcc";
        List<List<String>> lists = sol.partition(s);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

}
