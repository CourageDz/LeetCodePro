package alg11;

public class Solution2 {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0,j=n-1;
        int maxArea=0;
        while(i<j){
            int hi=height[i],hj=height[j];
            int area=Math.min(hi,hj)*(j-i);
            if(area>maxArea)
                maxArea=area;
            if(hi<hj)
                i++;
            else
                j--;
        }
        return maxArea;
    }

}
