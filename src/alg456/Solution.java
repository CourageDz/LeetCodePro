package alg456;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n + 1];
        int[] max = new int[n + 1];
        min[0] = Integer.MAX_VALUE;
        max[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min[i]) {
                min[i + 1] = nums[i];
                max[i + 1] = Integer.MIN_VALUE;
            } else if (nums[i] > max[i]) {
                min[i + 1] = min[i];
                max[i + 1] = nums[i];
                if (is132pattern(nums, min[i + 1], max[i + 1], i + 1))
                    return true;
            } else {
                min[i + 1] = min[i];
                max[i + 1] = max[i];
            }
        }
        return false;
    }

    public boolean is132pattern(int[] nums, int min, int max, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > min && nums[i] < max) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int nums[] = {2, 3, 4, 1};
        boolean result = sol.find132pattern(nums);
        System.out.println(result);
    }
}
