package byteDance.qiuZhao.test1;

import java.util.Scanner;

public class Main {
    static class Node{
        int key;
        Node next;
        public Node(int key) {
            this.key = key;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            Node head=new Node(0);
            Node p=head;

            for(int i=0;i<n;i++){
                Node q=new Node(sc.nextInt());
                head.next=q;
                head=q;
            }
            int k=sc.nextInt();
            System.out.println(getLastKNode(p.next,k).key);
        }

    }

    public static Node getLastKNode(Node root, int k) {
        Node p=root;
        Node q=root;
        if(k<0 || root==null)
            return null;

        for(int i=0;i<=k && p!=null;i++){
            p=p.next;
        }

        if(p==null){
            return null;
        }
        while (p!=null){
            q=q.next;
            p=p.next;
        }
        return q;
    }

}
