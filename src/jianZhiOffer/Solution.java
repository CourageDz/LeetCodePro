package jianZhiOffer;

import java.util.ArrayList;

/***
 * 让循环继续的条件是cols>startX×2并且rows>startY×2
 *
 * 分析打印每一步时的前提条件。
 *     第一步总是需要的，因为打印一圈至少有一步。
 *     如果只有一行，那就不用打印第二步了，由此第二步的前提条件是终止行号大于起始行号。
 *     需要第三步打印的前提条件是，圈内至少有两行两列，即除了要求终止行号大于起始行号外，还要求终止列号大于起始列号。
 *     需要打印第四步的前提条件是至少有三行两列，因此要求终止行号比起始行号至少大2，同时终止列号大于起始列号。
 *
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int start=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(m>2*start && n>2*start){
            int endX=n-start-1;
            int endY=m-start-1;
            for(int i=start;i<=endX;i++){
                list.add(matrix[start][i]);
            }

            if(start<endY){
                for(int i=start+1;i<=endY;i++){
                    list.add(matrix[i][endX]);
                }
            }

            if(start<endY && start<endX){
                for(int i=endX-1;i>=start;i--){
                    list.add(matrix[endY][i]);
                }
            }

            if(start<endX && start<endY-1){
                for(int i=endY-1;i>start;i--){
                    list.add(matrix[i][start]);
                }
            }
            start++;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
         int[][] matrix={{1,2,3},{4,5,6}};
        System.out.println(sol.printMatrix(matrix));
    }

}