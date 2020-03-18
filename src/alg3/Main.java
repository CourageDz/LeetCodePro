package alg3;

import java.util.HashMap;
import java.util.Map;

/***
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 解法 ：map+两个指针
 */

public class Main {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int ll = map.get(c) + 1;
                if (ll > low) {
                    low = ll;
                }
                map.put(c, i);
            } else {
                map.put(c, i);
            }
            int temp = i - low + 1;
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Main main = new Main();
        String s = "abba";
        System.out.println(main.lengthOfLongestSubstring(s));
    }
}
