package jianZhiOffer.deleteRepeatNode;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode front = null, cur = pHead;
        int val = pHead.val;
        ListNode first = new ListNode(val - 1);
        val--;
        first.next = pHead;
        front = first;
        boolean flag = false;
        if (cur == null) {
            return null;
        }
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                flag = true;
            } else {
                if (flag) {
                    front.next = cur.next;
                    flag = false;
                } else {
                    front = front.next;
                }
                val = cur.next.val;
            }
            cur = cur.next;
        }
        return first.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = new ListNode(array[0]);
        ListNode c = head;
        for (int i = 1; i < array.length; i++) {
            ListNode p = new ListNode(array[i]);
            c.next = p;
            c = p;
        }
        Solution sol = new Solution();
        ListNode res = sol.deleteDuplication(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}