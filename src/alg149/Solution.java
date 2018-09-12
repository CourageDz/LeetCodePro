package alg149;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxPoints(Point[] points) {
        int n=points.length;
        if(n<=2)
            return n;
        Map<Double,Integer> slopes =new HashMap<>();
        int max=0;
        for (int i = 0; i <n ; i++) {
            int samePoint =0;
            for (int j = 0; j <n ; j++) {
                double slope=getSlope(points[i],points[j]);
                if(points[i].x==points[j].x&&points[i].y==points[j].y){
                    samePoint++;
                    continue;
                }
//                System.out.println(slope);
                if(slopes.containsKey(slope)){
                    int count =(int)slopes.get(slope)+1;
                    slopes.put(slope,count);

                }else{
                    slopes.put(slope,1);

                }
            }
            if (slopes.keySet().size() == 0) {//如果slopes为空
                max = samePoint > max ? samePoint : max;
            } else {
                for (double  key : slopes.keySet()) {
                    max = Math.max((samePoint + slopes.get(key)), max);
                }
            }
            slopes.clear();
        }

        return max;
    }
    public double getSlope(Point a,Point b){
        if((a.x-b.x)==0){
            return Integer.MAX_VALUE;
        }else if((a.y-b.y)==0)
            return 0;
        return (b.y-a.y)*1.0/(b.x-a.x);
    }

    public static void main(String[] args) {
        Solution sol =new Solution();

        int n=3;
        Point points[]=new  Point[n];
//        points[0]=new Point(1,1);
//        points[1]=new Point(3,2);
//        points[2]=new Point(5,3);
//        points[3]=new Point(4,1);
//        points[4]=new Point(2,3);
//        points[5]=new Point(1,4);
        points[0]=new Point(0,0);
        points[1]=new Point(94911151,94911150);
        points[2]=new Point(94911152,94911151);


        int result =sol.maxPoints(points);
        System.out.println(result);
    }
}
