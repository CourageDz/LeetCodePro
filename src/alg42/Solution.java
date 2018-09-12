package alg42;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int maxLeft=0,maxRight=0;
        int sum=0;
        while(left<=right){
            if(height[left] < height[right]){
                if(height[left]>= maxLeft) {
                    maxLeft = height[left];
                }else
                    sum+= maxLeft - height[left];
                left++;
            }else{
                if (height[right]> maxRight ) {
                    maxRight = height[right];
                }else
                    sum+=maxRight-height[right];
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int heights[]={5,2,1,2,1,5};
        int result=sol.trap(heights);
        System.out.println(result);
    }
}
