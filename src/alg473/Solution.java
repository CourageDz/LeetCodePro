package alg473;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    //dfs
    public boolean makesquare(int[] nums) {
        int n = nums.length;
        if (n == 0 || nums == null)
            return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 4 != 0)
            return false;
        else {
            int avg = sum / 4;
            List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(numsList, Collections.reverseOrder());
            int[] counts = new int[4];
            return dfs(0, avg, counts, numsList);
        }
    }

    public boolean dfs(int i, int avg, int[] counts, List<Integer> nums) {
        if (i == nums.size()) {
            return counts[0] == counts[1] && counts[1] == counts[2] && counts[2] == counts[3];
        }
        int num = nums.get(i);
        for (int j = 0; j < 4; j++) {
            if (counts[j] + num <= avg) {
                counts[j] += num;
                if (dfs(i + 1, avg, counts, nums))
                    return true;
                counts[j] -= num;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {10, 6, 5, 5, 5, 3, 3, 3, 2, 2, 2, 2};
        boolean result = sol.makesquare(nums);
        System.out.println(result);
    }
}
