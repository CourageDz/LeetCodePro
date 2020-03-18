package jianZhiOffer.maxSubSerial;

import java.util.Comparator;

public class Solution {
    class Mycomparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] + max) > 0) {
                max += array[i];
            } else {
                max = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        int resule = sol.FindGreatestSumOfSubArray(array);
        System.out.println(resule);
    }
}
