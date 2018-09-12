package alg36;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        boolean is=true;
        Map <Character ,Boolean> num=new HashMap<>(9);
        num=clearMap(num);

        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.')
                    continue;
                else if(!num.get(board[i][j])){
                    num.put(board[i][j],true);
                }else
                    return false;
            }
            clearMap(num);
        }
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[j][i]=='.')
                    continue;
                else if(!num.get(board[j][i])){
                    num.put(board[j][i],true);
                }else
                    return false;
            }
            clearMap(num);
        }
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                for (int k = 0; k <3 ; k++) {
                    int t=k+i*3;
                    for (int l = 0; l <3 ; l++) {
                        int m=l+j*3;
                        if(board[t][m]=='.')
                            continue;
                        else if(!num.get(board[t][m])){
                            num.put(board[t][m],true);
                        }else
                            return false;
                     }
                }
                clearMap(num);
            }
        }
        return true;
    }
    public boolean isValidSudoku2(char[][] board) {
        int i, j, c;
        int row[][]=new int [9][9], col[][]=new int [9][9], block[][][]=new int [3][3][9];
        for (int k = 0; k <9 ; k++) {
            Arrays.fill(row[k],0);
            Arrays.fill(col[k],0);
        }
        for (int l = 0; l <3; l++) {
            for (int k = 0; k <3 ; k++) {
                Arrays.fill(block[l][k],0);
            }
        }
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    c = board[i][j] - '1';
                    if (row[i][c]!=0 || col[j][c]!=0 || block[i / 3][j / 3][c]!=0)
                        return false;
                    else {
                        row[i][c] ++;
                        col[j][c] ++;
                        block[i / 3][j / 3][c]++;
                    }
                }
            }
        }
        return true;
    }
    public Map<Character,Boolean> clearMap(Map<Character,Boolean>num){
        int n=num.size();
        String s1="123456789";
        char []nums =new char[9];
        nums=s1.toCharArray();
        for (int i = 0; i <n ; i++) {
            num.put(nums[i],false);
        }
        return num;
    }


    public static void main(String[] args) {
        Solution sol =new Solution();
        Map <Character ,Boolean> num=new HashMap<>(9);
        char [][]board =new char[9][9];
        String s="53..7....";
        board[0]=s.toCharArray();
        s="6..195...";
        board[1]=s.toCharArray();
        s=".98....6.";
        board[2]=s.toCharArray();
        s="8...6...3";
        board[3]=s.toCharArray();
        s="4..8.3..1";
        board[4]=s.toCharArray();
        s="7...2...6";
        board[5]=s.toCharArray();
        s=".6....28.";
        board[6]=s.toCharArray();
        s="...419..5";
        board[7]=s.toCharArray();
        s="....8..79";
        board[8]=s.toCharArray();
        boolean is=sol.isValidSudoku(board);
        System.out.println(is);
    }
}
