package jianZhiOffer.uglyNumber;

/***
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] nums = new int[index + 1];
        nums[0] = 1;
        int i1 = 0, i2 = 0, i3 = 0;
        int i = 1;
        while (i < index) {
            int temp = Math.min(nums[i1] * 2, Math.min(nums[i2] * 3, nums[i3] * 5));
            if (temp == nums[i1] * 2) {
                i1++;
            }
            if (temp == nums[i2] * 3) {
                i2++;
            }
            if (temp == nums[i3] * 5) {
                i3++;
            }
            nums[i++] = temp;
        }
        return nums[index - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int reu = sol.GetUglyNumber_Solution(6);
        System.out.println(reu);
    }
}
