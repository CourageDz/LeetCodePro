package alg118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> num = new ArrayList<>(i + 1);
            int l = 0;
            while (l < i + 1) {
                if (l == 0 || l == i) {
                    num.add(1);
                } else {
                    num.add(nums.get(i - 1).get(l - 1) + nums.get(i - 1).get(l));
                }
                l++;
            }
            nums.add(num);
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> result = sol.generate(5);
        for (List<Integer> nums : result) {
            for (Integer num : nums) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }
}
