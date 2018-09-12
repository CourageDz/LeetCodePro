package alg11;

public class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int area[][]=new int[n][n];
        int maxArea=0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=n-i-1 ; j++) {
                int k=j+i;
                area[j][k]=Math.min(height[j],height[k])*(j-i);
                if(area[j][k]>maxArea)
                    maxArea=area[j][k];
            }
        }
        return maxArea;
    }
}
