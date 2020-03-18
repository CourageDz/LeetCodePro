package alg147;


public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head.next, pFront = head, pHead = head, pHeadFront = null;
        while (p != null) {
            while (p.val >= pHead.val && pHead != p) {
                pHeadFront = pHead;
                pHead = pHead.next;
            }
            if (pHeadFront == null) {
                pFront.next = p.next;
                p.next = head;
                head = p;
                p = pFront.next;
            } else if (pHead == p) {
                pFront = p;
            } else {
                pFront.next = p.next;
                pHeadFront.next = p;
                p.next = pHead;
            }
            pHead = head;
            pHeadFront = null;
            p = pFront.next;
        }
        return head;
    }

    //简洁写法
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while (cur != null) {
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        p4.next = p2;
        p2.next = p1;
        p1.next = p3;
        ListNode p = sol.insertionSortList(p4);
        while (p != null) {
            System.out.println(p.val + "  ");
            p = p.next;
        }
    }
}
