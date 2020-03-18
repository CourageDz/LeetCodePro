package alg236;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> nodeLabel = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        containSubNode(root, p, q);
        int label = nodeLabel.get(root.val);
        if (label != 3)
            return null;
        else {
            return dfs(root, p, q);
        }
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        if (nodeLabel.get(node.val) == 3) {
            int left = node.left == null ? 0 : nodeLabel.get(node.left.val);
            int right = node.right == null ? 0 : nodeLabel.get(node.right.val);
            if (left != 3 && right != 3)
                return node;
            else if (left == 3) {
                return dfs(node.left, p, q);
            } else {
                return dfs(node.right, p, q);
            }
        } else {
            return null;
        }
    }

    public int containSubNode(TreeNode par, TreeNode child1, TreeNode child2) {
        if (par == null)
            return 0;
        else if (nodeLabel.containsKey(par.val))
            return nodeLabel.get(par.val);
        else {
            int left = containSubNode(par.left, child1, child2);
            int right = containSubNode(par.right, child1, child2);
            if (par.val == child1.val) {
                int sum = 1 + left + right;
                nodeLabel.put(par.val, sum);
                return sum;
            } else if (par.val == child2.val) {
                int sum = 2 + left + right;
                nodeLabel.put(par.val, 2 + left + right);
                return sum;
            } else {
                int sum = left + right;
                nodeLabel.put(par.val, left + right);
                return sum;
            }
        }
    }

    public TreeNode stringToTreeNode(String input) {
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

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "(3,5,1,6,2,0,8,null,null,7,4)";
        TreeNode root = sol.stringToTreeNode(s);
        TreeNode p = root.right;
        TreeNode q = root.left.right.right;
        TreeNode result = sol.lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }
}
