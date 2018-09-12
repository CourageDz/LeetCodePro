package alg872;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>root1Nums=new ArrayList<>();
        List<Integer>root2Nums=new ArrayList<>();
        dfsTree(root1,root1Nums);
        dfsTree(root2,root2Nums);
        int n1=root1Nums.size();
        int n2=root2Nums.size();
        if(n1!=n2)
            return false;
        for (int i = 0; i <n1 ; i++) {
            if(root1Nums.get(i)!=root2Nums.get(i))
                return false;
        }
        return true;
    }

    public void dfsTree(TreeNode root,List<Integer>rootNums){
        if(root==null)
            return ;
        if(root.left==null && root.right==null){
            rootNums.add(root.val);
            return;
        }
        else if(root.left!=null)
            dfsTree(root.left,rootNums);
        if(root.right!=null)
            dfsTree(root.right,rootNums);
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
    public void displayTree(TreeNode root){
        Queue<TreeNode> nodes=new LinkedList<>();
        TreeNode parent;
        nodes.offer(root);
        while (!nodes.isEmpty()){
            parent=nodes.poll();
            System.out.println(parent.val+" ");
            if(parent.left!=null){
                nodes.offer(parent.left);
            }
            if(parent.right!=null){
                nodes.offer(parent.right);
            }
        }
    }


    public static void main(String[] args) {
        String s1="(3,5,1,6,2,9,8,null,null,7,4)";
        Solution sol=new Solution();
        TreeNode root=stringToTreeNode(s1);
        String s2="(3,5,1,4,4,9,8,6,7)";
        TreeNode root2=stringToTreeNode(s2);
        boolean result=sol.leafSimilar(root,root2);
        System.out.println(result);
//        sol.displayTree(root);
//        List<Integer> nums=new ArrayList<>();
//        sol.dfsTree(root,nums);
//        for (int i:nums ) {
//            System.out.println(i);
//        }

    }
}
