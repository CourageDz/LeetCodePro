package simulationYongYou0831.t2;

import java.util.Scanner;

public class Main {
    static class Node {
        char c;
        Node left;
        Node right;

        public Node(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] items = s.split(",");
            String result = getPostOfS(items[0].toCharArray(), items[1].toCharArray());
            System.out.println(result);
        }
    }

    private static String getPostOfS(char[] firsts, char[] middle) {
        if (firsts.length != middle.length) {
            return "";
        }
        int n = firsts.length;
        Node root = BuildTree(firsts, 0, n - 1, middle, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        postNode(root, sb);
        return sb.toString();
    }

    private static void postNode(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        postNode(root.left, sb);
        postNode(root.right, sb);
        sb.append(root.c);
    }

    private static Node BuildTree(char[] firsts, int start1, int end1, char[] middle, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }
        Node root = new Node(firsts[start1]);
        int index = 0;
        for (int i = start2; i <= end2; i++) {
            if (middle[i] == firsts[start1]) {
                index = i;
                break;
            }
        }
        root.left = BuildTree(firsts, start1 + 1, index - start2 + start1, middle, start2, index - 1);
        root.right = BuildTree(firsts, index - start2 + start1 + 1, end1, middle, index + 1, end2);
        return root;
    }

}
