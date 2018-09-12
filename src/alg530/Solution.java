package alg530;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //中序遍历
    int min=Integer.MAX_VALUE;
    Integer prev=null;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return min;
        getMinimumDifference(root.left);
        if(prev!=null){
            min=Math.min(min,root.val-prev);
        }
        prev=root.val;
        getMinimumDifference(root.right);
        return min;
    }
}
