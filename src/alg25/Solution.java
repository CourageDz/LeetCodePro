package alg25;

public class Solution {
    int length(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (length(head) < k) return head;
        if (head == null || k == 0) {
            return head;
        }
        ListNode result = null;
        ListNode next = null;
        ListNode tail = head;
        int i = 0;
        while (head != null && i < k) {
            next = head.next;
            head.next = result;
            result = head;
            head = next;
            i++;
        }
        //System.out.println("head:" + head.val + "Tail:" + tail.val);
        if (head != null) {
            tail.next = reverseKGroup(head, k);
        }
        return result;
    }

    public ListNode myReverseKGroup(ListNode head, int k) {
        ListNode op = new ListNode(0);
        op.next = head;
        ListNode p = op;
        ListNode q = p.next;
        int count = 0;
        while (q != null) {
            ListNode[] nodes = new ListNode[k];
            int i = 0;
            for (i = 0; i < k; i++) {
                nodes[i] = q;
                q = q.next;
                if (q == null) {
                    break;
                }
            }
            if (i == k || i == k - 1) {
                for (int j = k - 1; j >= 0; j--) {
                    p.next = nodes[j];
                    p = p.next;
                }
                p.next = null;
            } else {
                for (int j = 0; j <= i; j++) {
                    p.next = nodes[j];
                    p = p.next;
                }
            }
        }
        return op.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l = new ListNode(0);
        ListNode ol = l;
        int k = 5;
        ListNode[] nodes = new ListNode[k];
        for (int i = 1; i <= 5; i++) {
            nodes[i - 1] = new ListNode(i);
            l.next = nodes[i - 1];
            l = l.next;
        }
        ListNode result = sol.reverseKGroup(ol.next, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
