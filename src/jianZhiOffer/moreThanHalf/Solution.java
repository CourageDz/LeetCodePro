package jianZhiOffer.moreThanHalf;

/***
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        int index = quickSort(array, 0, n - 1);
        int low = 0, high = n - 1;
        while (index != n / 2) {
            if (index > n / 2) {
                high = index - 1;
            } else {
                low = index + 1;
            }
            index = quickSort(array, low, high);
        }
        int count = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (array[index] == array[i]) {
                count++;
            } else {
                break;
            }
        }
        for (int i = index + 1; i < n; i++) {
            if (array[index] == array[i]) {
                count++;
            } else {
                break;
            }
        }
        if (2 * count > n) {
            return array[index];
        } else {
            return -1;
        }
    }

    public int quickSort(int[] array, int start, int end) {
        if (start > end)
            return -1;
        int temp = array[start];
        int l = start, r = end;
        while (l != r) {
            while (array[r] >= temp && r > l) {
                r--;
            }

            while (array[l] <= temp && r > l) {
                l++;
            }

            if (l < r) {
                int ts = array[l];
                array[l] = array[r];
                array[r] = ts;
            }
        }
        array[start] = array[r];
        array[r] = temp;
        return r;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {3, 2, 3, 2, 2, 2, 5, 4, 2};
        int result = sol.MoreThanHalfNum_Solution(array);
        System.out.println(result);
    }

}
