package alg2;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l=new ListNode(0);
        ListNode p,q,r;
        p=l1;q=l2;r=l;
        int carry=0;
        while(p!=null||q!=null){
            int p1=(p!=null)? p.val:0;
            int q1=q!=null ? q.val:0;
            carry=p1+q1+carry;
            r.next=new ListNode(carry%10);
            carry/=10;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
            r=r.next;
        }
        if(carry!=0)
            r.next=new ListNode(carry);
        return l.next;
    }

}
