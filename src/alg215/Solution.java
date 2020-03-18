package alg215;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int myfindKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            if (pq.size() < k)
                pq.offer(num);
            else {
                int min = pq.peek();
                if (min < num) {
                    pq.remove();
                    pq.offer(num);
                }
            }
        }
        return pq.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k)
                lo = j + 1;
            else if (j > k)
                hi = j - 1;
            else
                break;
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (i <= j) {
            while (i < hi && a[++i] <= a[lo]) ;
            while (j > lo && a[--j] >= a[lo]) ;
            if (i < j)
                exch(a, i, j);
            else
                break;
        }
        exch(a, j, lo);
        return j;
    }


    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int nums[] = {3, 2, 1, 5, 6, 4};
        int result = sol.findKthLargest(nums, 2);
        System.out.println(result);
    }
}
