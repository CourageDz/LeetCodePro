package alg450;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        TreeNode par = new TreeNode(0);
        par.left = root;
        dfsDelNode(par, 1, root, key);
        return par.left;
    }

    public void dfsDelNode(TreeNode parent, int dir, TreeNode cur, int key) {
        if (cur.val == key) {
            TreeNode replace = findLeftestNode(cur);
            if (replace == null)
                replace = findRightestNode(cur);
            if (dir == 1) {
                parent.left = replace;
                if (replace != null) {
                    replace.left = cur.left;
                    replace.right = cur.right;
                }
            } else if (dir == 2) {
                parent.right = replace;
                if (replace != null) {
                    replace.left = cur.left;
                    replace.right = cur.right;
                }
            }
        } else if (cur.val > key && cur.left != null)
            dfsDelNode(cur, 1, cur.left, key);
        else if (cur.val < key && cur.right != null) {
            dfsDelNode(cur, 2, cur.right, key);
        }
    }

    public TreeNode findRightestNode(TreeNode p) {
        TreeNode node = p.right;
        TreeNode par = p;
        if (node != null) {
            while (node.left != null) {
                par = node;
                node = node.left;
            }
            if (par != p) {
                par.left = node.right;
                node.right = null;
            } else {
                par.right = node.right;
                node.right = null;
            }
            return node;
        } else
            return null;
    }

    public TreeNode findLeftestNode(TreeNode p) {
        TreeNode node = p.left;
        TreeNode par = p;
        if (node != null) {
            while (node.right != null) {
                par = node;
                node = node.right;
            }
            if (par != p) {
                par.right = node.left;
                node.left = null;
            } else {
                par.left = node.left;
            }
            return node;
        } else
            return null;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
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
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void displayTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode parent;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            parent = nodes.poll();
            System.out.println(parent.val + " ");
            if (parent.left != null) {
                nodes.offer(parent.left);
            }
            if (parent.right != null) {
                nodes.offer(parent.right);
            }
        }
    }

    public static void main(String[] args) {
//        String s1 = "(7,4,10,2,6,8,13,null,3,5,null,null,9)";
        String s1 = "(1)";
        Solution sol = new Solution();
        TreeNode root = stringToTreeNode(s1);
        root = sol.deleteNode(root, 1);
        displayTree(root);
//        TreeNode node=sol.findLeftestNode(root);
//        System.out.println(root.left.right.val);
    }
}
