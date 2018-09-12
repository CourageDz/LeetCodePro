package alg30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<String > wordsList=new ArrayList<>();
        List<Integer> index=new ArrayList<>();
        dfs(wordsList,words,0);
        for (int i = 0; i <wordsList.size() ; i++) {
            String temp =wordsList.get(i);
            int n=s.length();
            int l=temp.length();
            for (int j = 0; j <n-l+1 ; j++) {
                int k=j;
                int subK=0;
                while (s.charAt(k)==temp.charAt(subK)&& subK<l){
                    k++;
                    subK++;
                }
                if(subK == l){
                    index.add(j);
                }
            }
        }
        return index;
    }
    public void dfs(List<String>wordsList,String []words,int n){
        if(n==words.length) {
            String s="";
            for (int i = 0; i <words.length ; i++) {
                 s+=words[i];
            }
            wordsList.add(s);
        }
        for (int i = n; i <words.length ; i++) {
            swapString(words,i,n);
            dfs(wordsList,words,n+1);
            swapString(words,i,n);
        }
    }
    public void swapString(String []words,int i,int j){
        String temp =words[i];
        words[i]=words[j];
        words[j]=temp;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        String[]words ={"foo","bar"};
        String s="barfoothefoobarman";
        List<Integer>result=sol.findSubstring(s,words);
        for (int i:result) {
            System.out.println(i+" ");

        }
    }
}
