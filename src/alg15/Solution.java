package alg15;

import java.util.*;

public class Solution {
    //三个for循环解
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                for (int k = j+1; k <nums.length ; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> threeNum =sortThreeNums(nums[i],nums[j],nums[k]);
                        if(!result.contains(threeNum)){
                            result.add(threeNum);
                        }
                    }
                }
            }
        }
        return result;
    }

    public  List<Integer> sortThreeNums(int i,int j,int k ){
        if(i>j){
            int temp=i;
            i=j;
            j=temp;
        }
        if(j>k){
            int temp=j;
            j=k;
            k=temp;
            if(i>j){
                int temp2=i;
                i=j;
                j=temp2;
            }
        }
        List<Integer>threeNum =new ArrayList<>();
        threeNum.add(i);
        threeNum.add(j);
        threeNum.add(k);
        return threeNum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        Vector<Integer> nums=new Vector<>();
//        while(sc.hasNext()){
//            int num =sc.nextInt();
//            nums.add(num);
//        }
        Solution sol =new Solution();
        List<List<Integer>> result =new ArrayList<>();
        int [] num={-1, 0, 1, 2, -1, -4};
        result=sol.threeSum(num);
        System.out.println(result);
    }
}
