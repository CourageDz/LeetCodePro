package alg241;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        int n=input.length();
        List<Integer> nums=new ArrayList<>();
        int k=0;
        for (int i = 0; i <n ; i++) {
            char c=input.charAt(i);
            if(c=='+'|| c=='-'||c=='*'){
                String leftPart=input.substring(0,i);
                String rightPart=input.substring(i+1);
                List<Integer> leftNums=diffWaysToCompute(leftPart);
                List<Integer> rightNums=diffWaysToCompute(rightPart);
                for (int leftNum: leftNums) {
                    for (int rithtNum:rightNums) {
                        int num=0;
                        switch (c){
                            case '+':   num=leftNum+rithtNum;
                                break;
                            case '*': num=leftNum*rithtNum;
                            break;
                            case '-': num=leftNum-rithtNum;
                            break;
                        }
                        nums.add(num);
                    }
                }
            }
        }
        if(nums.size()==0)
            nums.add(Integer.parseInt(input));
        return nums;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        String S= "2*3-4*5";
        List <Integer> result=sol.diffWaysToCompute(S);
        System.out.println(result);
    }


}
