package simulationXieChen0904.t1;


import java.util.Scanner;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    public static ListNode partition(ListNode head, int m) {
        ListNode preRoot = new ListNode(Integer.MAX_VALUE);
        ListNode pre = preRoot;
        pre.next = head;
        ListNode preNext = null;
        ListNode p = head;
        ListNode ppre = pre;
        ListNode post;
        while (p != null && p.val <= m) {
            pre = pre.next;
            ppre = ppre.next;
            p = p.next;
        }

        while (p != null) {
            if (p.val <= m) {
                preNext = pre.next;

                post = p.next;
                ppre.next = post;
                p.next = null;

                pre.next = p;

                p.next = preNext;

                pre = p;

                p = post;


            } else {
                ppre = p;
                p = p.next;
            }
        }
        return preRoot.next;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        while (in.hasNextLine()) {
            String s = in.nextLine().trim();
            int m = Integer.parseInt(s);
            String[] items = in.nextLine().trim().split(" ");
            int n = items.length;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    node = new ListNode(Integer.parseInt(items[i]));
                    head = node;
                } else {
                    node.next = new ListNode(Integer.parseInt(items[i]));
                    node = node.next;
                }
            }
            head = partition(head, m);
            if (head != null) {
                System.out.print(head.val);
                head = head.next;
                while (head != null) {
                    System.out.print(",");
                    System.out.print(head.val);
                    head = head.next;
                }
            }
            System.out.println();
        }
    }
}

