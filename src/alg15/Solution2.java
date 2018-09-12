package alg15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> Nums =new ArrayList<List<Integer>>();
        int left ,mid,right;
        for ( left=0; nums[left] <=0&&left<nums.length ; left++) {
            mid=left+1;
            right=nums.length-1;
            int temp=0-nums[left];
            if(left>0&&nums[left]==nums[left-1])
                continue;
            while(mid<right){
                if(nums[mid]+nums[right]==temp){
                    Nums.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    while(mid<right&&nums[++mid]==nums[mid-1]);
                    while (mid<right&&nums[--right]==nums[right+1]);
                }else if(nums[mid]+nums[right]>temp){
                    right--;
                }else
                    mid++;
            }
        }
        return Nums;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        Vector<Integer> nums=new Vector<>();
//        while(sc.hasNext()){
//            int num =sc.nextInt();
//            nums.add(num);
//        }
        Solution2 sol =new Solution2();
        List<List<Integer>> result =new ArrayList<>();
        int [] num={-1, 0, 1, 2, -1, -4};
        result=sol.threeSum(num);
        System.out.println(result);
    }
}
