package alg863;


import java.util.*;

public class Solution {
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//
//    }
    public TreeNode constructTree(String [] nums){
        int n=nums.length;
        int rootNum=Integer.parseInt(nums[0]);
        TreeNode root= new TreeNode(rootNum);
        int index=2;
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        nodeQueue.offer(root);
        int i=1;
        TreeNode parent=root;
        while(i<n) {
            if(index==2){
                parent=nodeQueue.poll();
                index=0;
            }
            if(nums[i]!="null"){
                int num=Integer.parseInt(nums[i]);
                if(index==0 && parent!=null){
                    TreeNode left= new TreeNode(num);
                    parent.left=left;
                    nodeQueue.offer(left);
                    index++;
                    i++;
                }else if(index==1 && parent!=null){
                    TreeNode right= new TreeNode(num);
                    parent.right=right;
                    nodeQueue.offer(right);
                    index++;
                    i++;
                }
            }else if( index==0 ){
                    nodeQueue.offer(null);
                    if(parent!=null)
                        parent.left=null;
                    index++;
                    i++;
            }
            else {
                nodeQueue.offer(null);
                if(parent!=null)
                    parent.right=null;
                index++;
                i++;
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
        Solution sol=new Solution();
        String [] nodes={"3","5","1","6","2","0","8","null","null","7","4"};
        TreeNode root=sol.constructTree(nodes);
        sol.displayTree(root);
    }
}
