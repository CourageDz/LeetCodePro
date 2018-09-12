package alg19;

public class Solution2 {
    //没有删除节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=new ListNode(0),p=first,q=p;
        p.next=head;
        for (int i = 0; i <n ; i++) {
            p=p.next;
        }
        while (p.next!=null){
            q=q.next;
            p=p.next;
        }
        q.next=q.next.next;
        head=first.next;
        return head;
    }
}
