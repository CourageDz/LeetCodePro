package alg652;

import java.util.*;

public class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> treeMap=new HashMap<>();
        List<TreeNode> result=new ArrayList<>();
        count(root,treeMap,result);
        return result;
    }
    public String count(TreeNode root,Map<String,Integer> treeMap,List<TreeNode> result){
        if(root==null)
            return "#";
        String key=root.val+","+count(root.left,treeMap,result)+","+count(root.right,treeMap,result);
        treeMap.put(key,treeMap.getOrDefault(key,0)+1);
        if(treeMap.get(key)==2)
            result.add(root);
        return key;
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
        String s1="(1,2,3,4,null,2,4,null,null,4)";
        Solution sol=new Solution();
        TreeNode root=stringToTreeNode(s1);
        List<TreeNode> result=sol.findDuplicateSubtrees(root);
        for (TreeNode node:result) {
            sol.displayTree(node);
        }

    }

}
