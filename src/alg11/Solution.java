package alg11;

public class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int i=0,j=height.length-1;
        while (i<j){
            if(height[i]<=height[j]){
                int area=height[i]*(j-i);
                max=Math.max(max,area);
                while (i<j && height[i+1]<=height[i])
                    i++;
                i++;
            }else {
                int area=height[j]*(j-i);
                max=Math.max(max,area);
                while(j>i && height[j-1]<=height[j])
                    j--;
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        int height[]={1,1};
        int result=sol.maxArea(height);
        System.out.println(result);
    }
}
