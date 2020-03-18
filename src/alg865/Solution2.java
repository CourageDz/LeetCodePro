package alg865;

import java.util.Map;

public class Solution2 {
    Map<TreeNode, Integer> nodeDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        nodeDepth.put(null, -1);
        dfs(root, null);
        int max = -1;
        for (int d : nodeDepth.values()) {
            max = Math.max(max, d);
        }
        return findDeepstNode(root, max);
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            nodeDepth.put(node, nodeDepth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode findDeepstNode(TreeNode node, int max) {
        if (node == null || nodeDepth.get(node) == max)
            return node;
        TreeNode L = findDeepstNode(node.left, max), R = findDeepstNode(node.right, max);
        if (L != null && R != null)
            return node;
        if (L != null)
            return L;
        if (R != null)
            return R;
        else
            return null;
    }
}
