package alg86;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode o = new ListNode(0), q, p = o, l = o, biger = o;
        o.next = head;
        boolean flag = false;
        while (p.next != null) {
            if (p.next.val >= x) {
                if (biger == o)
                    biger = p.next;
                p = p.next;
                flag = true;
            } else if (p.next.val < x && flag) {
                q = p.next;
                p.next = p.next.next;
                l.next = q;
                q.next = biger;
                l = l.next;
            } else {
                l = l.next;
                p = p.next;
            }
        }
        return o.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = sol.new ListNode(1);
        ListNode p1 = sol.new ListNode(1);
        ListNode p2 = sol.new ListNode(4);
        ListNode p3 = sol.new ListNode(2);
        ListNode p4 = sol.new ListNode(5);
        ListNode p5 = sol.new ListNode(2);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode result = sol.partition(head, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
