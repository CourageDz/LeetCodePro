package alg430;

public class Solution {
    //nullpointer exception
    public Node flatten(Node head) {
        dfsChildNode(head);
        return head;
    }

    public Node dfsChildNode(Node node) {
        Node next;
        if (node == null)
            return null;
        while (node.child == null && node.next != null) {
            node = node.next;
        }
        if (node.child != null) {
            next = node.next;
            node.next = node.child;
            node.next.prev = node;
            node.child = null;
            Node pre = dfsChildNode(node.next);
            pre.next = next;
            if (next != null)
                pre.next.prev = pre;
            node = dfsChildNode(node.next);
        }
        return node;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node node[] = new Node[14];
        for (int i = 1; i < 13; i++) {
            node[i] = new Node(i, null, null, null);
        }
        for (int i = 1; i < 6; i++) {
            node[i].next = node[i + 1];
        }
        for (int i = 7; i < 10; i++) {
            node[i].next = node[i + 1];
        }
        node[11].next = node[12];
        for (int i = 2; i < 7; i++) {
            node[i].prev = node[i - 1];
        }
        for (int i = 8; i < 11; i++) {
            node[i].prev = node[i - 1];
        }
        node[12].prev = node[11];
        node[3].child = node[7];
        node[8].child = node[11];
        Node result = sol.flatten(node[1]);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
