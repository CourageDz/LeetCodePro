package alg75;

public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        for (int k = 0; k < n; k++) {
            if (nums[k] == 0 && k != i)
                swap(nums, k--, i++);
            else if (nums[k] == 2 && k < j)
                swap(nums, k--, j--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        Solution sol = new Solution();
        sol.sortColors(nums);
        for (int x : nums) {
            System.out.println(x);
        }
    }
}
