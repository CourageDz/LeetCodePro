package alg2;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long  num1=0,num2=0,num3=0;
        int i=0;
        while (l1!=null){
            num1=l1.val*(int)Math.pow(10,i)+num1;
            l1=l1.next;
            i++;
        }
        i=0;
        while (l2!=null){
            num2=l2.val*(int)Math.pow(10,i)+num2;
            l2=l2.next;
            i++;
        }
        num3=num1+num2;
        ListNode x =new ListNode((int)num3%10);
        num3/=10;
        ListNode z=x;
        while (num3!=0){
            ListNode y =new ListNode((int)num3%10);
            z.next=y;
            z=z.next;
            num3/=10;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(new BufferedInputStream(System.in));
        String s1= sc.nextLine();
        String[]  c1=s1.split("\\s+");
        int []arr1 =new int[c1.length];
        for (int i = 0; i <c1.length ; i++) {
            arr1[i]=Integer.parseInt(c1[i]);
        }
        ListNode l1= new ListNode(arr1[0]);
        ListNode z1=l1;
        for (int i = 1; i <c1.length ; i++) {
            ListNode y=new ListNode(arr1[i]);
            z1.next=y;
            z1=z1.next;
        }

        String s2= sc.nextLine();
        String[]  c2=s2.split("\\s+");
        int []arr2 =new int[c2.length];
        for (int i = 0; i <c2.length ; i++) {
            arr2[i]=Integer.parseInt(c2[i]);
        }
        ListNode l2= new ListNode(arr2[0]);
        ListNode z2=l2;
        for (int i = 1; i <c2.length ; i++) {
            ListNode y=new ListNode(arr2[i]);
            z2.next=y;
            z2=z2.next;
        }

        Solution sol =new Solution();
        ListNode l3 =sol.addTwoNumbers(l1,l2);
        ListNode l= l3;
        while (l.next!=null){
            System.out.printf(l.val+"->");
            l=l.next;
        }
        System.out.println(l.val);


    }
}
