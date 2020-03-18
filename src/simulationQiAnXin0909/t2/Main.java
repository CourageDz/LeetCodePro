package simulationQiAnXin0909.t2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(" ");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            int leftNumber = Integer.parseInt(item);
            node.left = new TreeNode(leftNumber);
            nodeQueue.add(node.left);

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            int rightNumber = Integer.parseInt(item);
            node.right = new TreeNode(rightNumber);
            nodeQueue.add(node.right);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int level = Integer.parseInt(sc.nextLine().trim());
            String input = sc.nextLine().trim();
            TreeNode root = stringToTreeNode(input);
            String[] nodes = sc.nextLine().trim().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);
            int result = findMinFatherOfNodes(node1, node2, root);
            System.out.println(result);
        }
    }

    private static int findMinFatherOfNodes(int node1, int node2, TreeNode root) {
        if (root == null || root.val == -1) {
            return -1;
        }
        if (node1 == node2) {
            if (node1 == root.val) {
                return root.val;
            } else if (root.val > node1) {
                return findMinFatherOfNodes(node1, node2, root.left);
            } else if (root.val < node1) {
                return findMinFatherOfNodes(node1, node2, root.right);
            } else {
                return -1;
            }
        }
        int min = Math.min(node1, node2);
        int max = Math.max(node1, node2);
        if (hasNode(root.left, min) && hasNode(root.right, max)) {
            return root.val;
        } else if (root.val < min) {
            return findMinFatherOfNodes(node1, node2, root.right);
        } else if (root.val > max) {
            return findMinFatherOfNodes(node1, node2, root.left);
        } else {
            return -1;
        }
    }

    private static boolean hasNode(TreeNode root, int node1) {
        if (root == null) {
            return false;
        }
        if (root.val == node1) {
            return true;
        }
        if (root.val < node1) {
            return hasNode(root.right, node1);
        } else {
            return hasNode(root.left, node1);
        }
    }
}
