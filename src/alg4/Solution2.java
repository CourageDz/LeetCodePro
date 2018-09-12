package alg4;

import java.util.Scanner;

public class Solution2 {
    //递归法求解
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) {
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        int iMin = 0, iMax = n1, halflen = (n1 + n2 + 1) / 2;
        int maxLeft = 0, minRight = 0;

        while (iMin <= iMax) {
            int i = (iMax + iMin) / 2, j = halflen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {//i太小
                iMin += 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {//i太大
                iMax -= 1;
            } else {
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((n1 + n2) % 2 == 1) {
                    return maxLeft;
                } else {
                    if (i == n1) {
                        minRight = nums2[j];
                    } else if (j == n2) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums1[i], nums2[j]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }
            }
        }
        return 0.0;
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
        Solution2 sol =new Solution2();
        double mid =0;
        mid=sol.findMedianSortedArrays(num1,num2);
        System.out.println(mid);
    }
}
