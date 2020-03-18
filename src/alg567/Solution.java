package alg567;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int n1 = s1.length();
        int n2 = s2.length();
        for (int i = 0; i < n1; i++) {
            characterIntegerMap.put(s1.charAt(i), characterIntegerMap.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i <= n2 - n1; i++) {
            Map<Character, Integer> charMapCopy = new HashMap<>();
            for (Character c : characterIntegerMap.keySet()) {
                charMapCopy.put(c, characterIntegerMap.get(c));
            }
            int j = i + n1;
            String subS2 = s2.substring(i, j);
            boolean result = isPermutation(subS2, charMapCopy);
            if (result)
                return result;
        }
        return false;
    }

    public boolean isPermutation(String s, Map<Character, Integer> charMap) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                Integer value = charMap.get(c);
                value--;
                if (value < 0)
                    return false;
                charMap.put(c, value);
            } else
                return false;
        }
        int sum = 0;
        for (Integer value : charMap.values()) {
            sum += value;
        }
        if (sum != 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "aabc";
        String s2 = "abca";
        boolean reuslt = sol.checkInclusion(s1, s2);
        System.out.println(reuslt);
    }

}
