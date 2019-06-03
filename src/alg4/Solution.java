package alg4;

import java.util.Scanner;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if(m>n){
            int temp[];
            temp=nums2;
            nums2=nums1;
            nums1=temp;
            int tempN=n;
            n=m;
            m=tempN;
        }
        double midNum;
        int aLeft=0,aRight=n-1,bLeft=0,bRight=m-1;
        int mid=n+m+1;
        if(nums1[aRight]<=nums2[bLeft]){
            if(mid%2==1){
                midNum=(nums1[mid/2]+nums1[mid/2-1])*1.0/2;
            }else
                midNum=nums1[mid/2-1];
        }
        else if(nums1[aLeft]>=nums2[bRight]){
            if(mid%2==1){
            }
        }
        return 0;
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
