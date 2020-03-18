package alg889;

import java.util.Arrays;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        if (n == 0)
            return null;
        if (n == 1)
            return new TreeNode(pre[0]);
        else {
            TreeNode node = new TreeNode(pre[0]);
            if (post[n - 2] == pre[1]) {
                int[] nextPre = Arrays.copyOfRange(pre, 1, n);
                int[] nextPost = Arrays.copyOfRange(post, 0, n - 1);
                node.left = constructFromPrePost(nextPre, nextPost);
            } else {
                int jindex = 0, iindex = 0;
                for (int i = 0; i < n; i++) {
                    if (pre[i] == post[n - 2]) {
                        jindex = i;
                    }
                    if (post[i] == pre[1]) {
                        iindex = i;
                    }
                }

                int[] nextLPre = Arrays.copyOfRange(pre, 1, jindex);
                int[] nextLPost = Arrays.copyOfRange(post, 0, iindex + 1);
                node.left = constructFromPrePost(nextLPre, nextLPost);

                int[] nextRPre = Arrays.copyOfRange(pre, jindex, n);
                int[] nextRPost = Arrays.copyOfRange(post, iindex + 1, n - 1);
                node.right = constructFromPrePost(nextRPre, nextRPost);
            }
            return node;
        }
    }

    public static void main(String[] args) {
//        int[]pre={1,2,4,5,3,6,7};
//        int[] post={4,5,2,6,7,3,1};
        int[] pre = {3, 4, 2, 1};
        int[] post = {2, 1, 4, 3};
        Solution sol = new Solution();
        TreeNode root = sol.constructFromPrePost(pre, post);
        System.out.println(root.val);
    }
}
