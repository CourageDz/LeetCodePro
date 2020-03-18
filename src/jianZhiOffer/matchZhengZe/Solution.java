package jianZhiOffer.matchZhengZe;

/***
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution {
    public boolean match(char[] str, char[] pattern) {
        int n = str.length;
        int m = pattern.length;
        if (str == null && pattern == null) {
            return false;
        }
        return dfs(str, 0, n, 0, m, pattern);
    }

    public boolean dfs(char[] str, int c, int n, int k, int m, char[] pat) {
        if (c >= n && k >= m) {
            return true;
        }
        if (c <= n && k >= m) {
            return false;
        }

        if (k + 1 < m && pat[k + 1] == '*') {
            if (c >= n)
                return dfs(str, c, n, k + 2, m, pat);
            else {
                if (str[c] == pat[k] || pat[k] == '.') {
                    return dfs(str, c + 1, n, k + 2, m, pat) || dfs(str, c + 1, n, k, m, pat) || dfs(str, c, n, k + 2, m, pat);
                } else {
                    return dfs(str, c, n, k + 2, m, pat);
                }
            }
        }
        if (c >= n)
            return false;
        else {
            if (pat[k] == str[c] || pat[k] == '.') {
                return dfs(str, c + 1, n, k + 1, m, pat);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] s = "".toCharArray();
        char[] p = ".*".toCharArray();
        boolean result = sol.match(s, p);
        System.out.println(result);
    }
}