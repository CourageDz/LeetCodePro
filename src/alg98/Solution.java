package alg98;

/***
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
    public boolean dfs(TreeNode node){
        if(node==null)
            return true;
        else {
            boolean nodeStatus=dfs(node.left)&&dfs(node.right);
            if(nodeStatus){
                if(node.left!=null)
                    nodeStatus &=(getLeftMax(node.left)<node.val);
                if(node.right!=null)
                    nodeStatus &=(node.val<getRightMin(node.right));
                return nodeStatus;
            }else
                return nodeStatus;
        }
    }
    public int getLeftMax(TreeNode node){
        while (node.right!=null)
            node=node.right;
        return node.val;
    }
    public int getRightMin(TreeNode node){
        while (node.left!=null)
            node=node.left;
        return node.val;
    }
    public  static TreeNode stringToTreeNode(String input) {
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
        while(!nodeQueue.isEmpty()) {
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
        Solution sol =new Solution();
        String s="(10,5,15,null,null,6,20)";
        TreeNode root=Solution.stringToTreeNode(s);
        boolean result=sol.isValidBST(root);
        System.out.println(result);
    }
}

