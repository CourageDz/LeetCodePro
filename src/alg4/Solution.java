package alg4;

import java.util.Scanner;

public class Solution {
    //暴力法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int[] num3 = new int[n];
        int i=0,j=0,k=0;
        double ans=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]<=nums2[j]){
                num3[k++]=nums1[i++];
            }else
                num3[k++]=nums2[j++];
        }
        if(i<nums1.length){
            for (int t = i; t <nums1.length ; t++) {
                num3[k++]=nums1[t++];
            }
        }
        if(j<nums2.length){
            for (int t = j; t <nums2.length ; t++) {
                num3[k++]=nums2[t++];
            }
        }
        if(k%2==0){
            ans=(num3[k/2-1]+num3[k/2])/2.0;
        }else
            ans=num3[(k+1)/2-1];
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] nums1=null;
        nums1=sc.nextLine().split(" ");
        int num1[]=new int[nums1.length];
        for (int i = 0; i <num1.length ; i++) {
            num1[i]=Integer.valueOf(nums1[i]);
        }
        String[] nums2=null;
        nums2=sc.nextLine().split(" ");
        int num2[]=new int[nums2.length];
        for (int i = 0; i <num2.length ; i++) {
            num2[i]=Integer.valueOf(nums2[i]);
        }
        Solution sol =new Solution();
        double mid =0;
        mid=sol.findMedianSortedArrays(num1,num2);
        System.out.println(mid);
    }
}
