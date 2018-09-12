package alg49;

import java.util.*;

public class Solution {
    //全排列一个字符串，保存到一个集合中，判断数组是否包含在集合中，若在，则添加到List中。不知道为什么没通过，错误案例为["",""],该代码只输出一个列表，而答案是两个。
    public List<List<String>> myGroupAnagrams(String[] strs) {
        Map<String,Boolean> strMap= new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            strMap.put(strs[i],false);
        }
        List<List<String>> groupAnagram=new ArrayList<>();
        for (int i = 0; i <strs.length ; i++) {
            if(strMap.get(strs[i])==false){
                List<String> stringList=new ArrayList<>();
                Set<String> stringSet=new HashSet<>();
                dfs(strs[i].toCharArray(),stringSet,0);
                for (int j = i; j <strs.length ; j++) {
                    if(stringSet.contains(strs[j]) && (strMap.get(strs[j])==false)){
                        stringList.add(strs[j]);
                        strMap.put(strs[j],true);
                    }
                }
                groupAnagram.add(stringList);
            }
            else
                continue;
        }
        return groupAnagram;
    }
    public void dfs(char s[], Set<String>stringSet,int j){
        if(j==s.length){
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i <s.length ; i++) {
                sb.append(s[i]);
            }
            stringSet.add(sb.toString());
        }
        for (int i = j; i <s.length ; i++) {
            swapChar(s,i,j);
            dfs(s,stringSet,j+1);
            swapChar(s,i,j);
        }
    }
    public void swapChar(char s[],int i,int j){
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }

    public List<List<String>> groupAnagrams(String[] strs){
        if (strs.length == 0) return new ArrayList();
        Map<String,List<String>> stringMap=new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            char a[]=strs[i].toCharArray();
            Arrays.sort(a);
            String key=String.valueOf(a);
//            String key=a.toString(); //toString 返回的是不同的String
            if(!stringMap.containsKey(key))
                stringMap.put(key,new ArrayList<>());
            stringMap.get(key).add(strs[i]);
        }
        return new ArrayList<>(stringMap.values());
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        String[]strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupStrings=sol.groupAnagrams(strs);
        for (int i = 0; i <groupStrings.size() ; i++) {
            System.out.println(groupStrings.get(i));
        }
    }
}
