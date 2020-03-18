package jianZhiOffer.findKstNodeInTree;


import jianZhiOffer.zhiTypePrintTree.TreeNode;

import static jianZhiOffer.zhiTypePrintTree.Solution.stringToTreeNode;

public class Solution {
    TreeNode target;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        dfs(0, k, pRoot);
        return target;
    }

    public int dfs(int c, int k, TreeNode p) {
        if (p == null || c > k) {
            return c;
        }
        int left = dfs(c, k, p.left);
        if (left == k - 1) {
            target = p;
            return k;
        }
        int right = dfs(left + 1, k, p.right);
        return right;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "(8,6,10,5,7,9,11)";
        TreeNode root = stringToTreeNode(s);
        TreeNode res = sol.KthNode(root, 4);
        System.out.println(res.val);
    }
}
