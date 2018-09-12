package alg19;

import java.util.List;
import java.util.Scanner;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count =0;
        ListNode q =head;
        while (q!=null){
            count++;
            q=q.next;
        }
        q=head;
        if(count==n){
            head=q.next;
            return head;
        }
        for (int i = 1; i <count-n ; i++) {
            q=q.next;
        }
        ListNode p =q.next;
        q.next=p.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int h1=sc.nextInt();
        ListNode head=new ListNode(h1);
        ListNode q=head;
        for (int i = 1; i <n ; i++) {
            int x=sc.nextInt();
            ListNode p=new ListNode(x);
            q.next=p;
            q=q.next;
        }
        Solution sol =new Solution();
        q=sol.removeNthFromEnd(head,2);

        while(q!=null){
            System.out.println(q.val);
            q=q.next;
        }
    }
}
