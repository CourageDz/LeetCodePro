package alg865;

public class Solution3 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    public TagNode dfs(TreeNode node) {
        if (node == null)
            return new TagNode(null, 0);
        TagNode L = dfs(node.left), R = dfs(node.right);
        if (L.dist > R.dist)
            return new TagNode(L.node, L.dist + 1);
        if (L.dist < R.dist)
            return new TagNode(R.node, R.dist + 1);
        else
            return new TagNode(node, L.dist + 1);
    }

    class TagNode {
        TreeNode node;
        int dist;

        public TagNode(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
