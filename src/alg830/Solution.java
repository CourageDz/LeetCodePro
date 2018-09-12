package alg830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer >> largeGroupList =new ArrayList<>();
        int n=S.length();
        char last=S.charAt(0);
        int count =1,indexI=0,indeJ=0;
        for (int i = 1; i <n ; i++) {
            char nouC=S.charAt(i);
            if(nouC==last){
                count++;
                indeJ=i;
            }else {
                if(count>=3){
                    largeGroupList.add(Arrays.asList(indexI,indeJ));
                }
                count=1;
                last=nouC;
                indexI=indeJ=i;
            }
        }
        if(count>=3){
            largeGroupList.add(Arrays.asList(indexI,indeJ));
        }
        return largeGroupList;
    }
    public List<List<Integer>> largeGroupPositions2(String S) {
        int i = 0, j = 0, N = S.length();
        List<List<Integer>> res = new ArrayList<>();
        while (j < N) {
            while (j < N && S.charAt(j) == S.charAt(i)) ++j;
            if (j - i >= 3) res.add(Arrays.asList(i, j - 1));
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        List<List<Integer >> largeGroupList=sol.largeGroupPositions2("aaa");
        for (List<Integer> nums :largeGroupList) {
            System.out.println(nums);
        }
    }
}
