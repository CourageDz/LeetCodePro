package alg817;

import java.util.Arrays;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // more quick
    public int numComponents2(ListNode head, int[] G) {
        boolean[] present = new boolean[10000];
        for (int i = 0; i < G.length; i++)
            present[G[i]] = true;
        int cnt = 0;
        boolean isThere = true;

        while (head != null) {
            if (!present[head.val])
                isThere = true;
            else {
                if (isThere) {
                    cnt++;
                    isThere = false;
                }
            }
            head = head.next;
        }
        return cnt;
    }

    public int numComponents(ListNode head, int[] G) {
        ListNode p = head;
        if (head == null)
            return 0;
        int count = 0;
        Arrays.sort(G);
        boolean flag = false;
        while (p != null) {
            int x = p.val;
            boolean thisFlag = binarySearch(G, x);
            if (thisFlag) {
                if (!flag)
                    count++;
                flag = true;
            } else
                flag = false;
            p = p.next;
        }
        return count;
    }

    public boolean binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return true; // key found
        }
        return false;  // key not found.
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode p0 = sol.new ListNode(0);
        ListNode p1 = sol.new ListNode(1);
        ListNode p2 = sol.new ListNode(2);
        ListNode p3 = sol.new ListNode(3);
        ListNode p4 = sol.new ListNode(4);
        p0.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        int[] G = {0, 2, 4};
        int result = sol.numComponents(p0, G);
        System.out.println(result);

    }

}
