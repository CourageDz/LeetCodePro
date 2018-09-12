package alg24;

import java.util.Scanner;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fHead =new ListNode(0);
        ListNode l1,l2;
        ListNode r=fHead;
        while (head.next!=null){
            l1=head;
            l2=head.next;
            r.next=l2;
            r=r.next;
            r.next=l1;
            r=r.next;
            head=r.next;
        }
        return fHead.next;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        Scanner sc =new Scanner(System.in);
        ListNode head=new ListNode(1);
        ListNode q=head;
        for (int i = 2; i <=4 ; i++) {
            ListNode p=new ListNode(i);
            q.next=p;
            q=q.next;
        }
        head=sol.swapPairs(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
