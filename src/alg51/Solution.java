package alg51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions=new ArrayList<>();
        int path[]=new int [n];
        Arrays.fill(path,0);
        dfsSearch(path,solutions,0);
        return solutions;
    }
    public  void dfsSearch(int path[],List<List<String>>solutions,int j){
        int n=path.length;
        if(j==n){
            List<String> pathS=new ArrayList<>();
            StringBuffer sb =new StringBuffer();
            for (int i:path) {
                for (int k = 0; k <i ; k++) {
                    sb.append('.');
                }
                sb.append('Q');
                for (int k = i+1; k <n ; k++) {
                    sb.append('.');
                }
                pathS.add(sb.toString());
                sb.delete(0,n);
            }
            solutions.add(pathS);
        }
        else{
            for (int i = 0; i <n ; i++) {
                    path[j]=i;
                    if(place(j,path))
                        dfsSearch(path,solutions,j+1);
            }
        }
    }
    public boolean place(int j,int  path[]){
        for (int i = 0; i <j ; i++) {
            if((Math.abs(path[i]-path[j])==Math.abs(i-j)) || (path[i]==path[j]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        List<List<String>> solutions=sol.solveNQueens(4);
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println(solutions.get(i));
        }
    }
}
