package jianZhiOffer.serialAndDesTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    String Serialize(TreeNode root) {
        String s = "";
        if (root == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p != null) {
                sb.append("," + p.val);
                queue.offer(p.left);
                queue.offer(p.right);
            } else {
                sb.append(",#");
            }
        }
        return sb.toString().substring(1);
    }


    TreeNode Deserialize(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String[] items = str.trim().split(",");
        if (items == null || items.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(items[0]));
        queue.offer(root);
        int index = 1;
        String item = null;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (index == str.length()) {
                break;
            }
            item = items[index++];
            if (!item.equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(item));
                p.left = left;
                queue.offer(left);
            }
            if (index == str.length()) {
                break;
            }
            item = items[index++];
            if (!item.equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(item));
                p.right = right;
                queue.offer(right);
            }

        }
        return root;
    }

    public static void main(String[] args) {
        String s = "5,#,3,#,1,#,#";
        Solution sol = new Solution();
        TreeNode root = sol.Deserialize(s);
        String res = sol.Serialize(root);
        System.out.println(res);
    }
}