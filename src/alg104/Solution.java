package alg104;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int depth) {
        if (node == null)
            return depth;
        else {
            int left = dfs(node.left, depth + 1);
            int right = dfs(node.right, depth + 1);
            return left >= right ? left : right;
        }
    }
}
