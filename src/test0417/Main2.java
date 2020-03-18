package test0417;

import java.util.Scanner;

public class Main2 {
    private int count = 0;

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = main2.insertYunSuanFu(n, m);
        System.out.println(result);
    }

    private int insertYunSuanFu(int n, int m) {
        dfs(n, m, 1, 0, 0, '+', '+');
        return count;
    }

    private void dfs(int n, int m, int i, int lastNum, int result, char lastC, char c) {
        char[] cs = {'+', '-', ' '};
        int temp = 0;
        if (lastC != ' ') {
            temp = doYunSuan(lastC, result, i);
        } else {
            lastNum = lastNum * 10 + i;
            temp = doYunSuan(c, result, lastNum);
        }
        if (i == n) {
            if (m == temp)
                count++;
            return;
        }
        for (int j = 0; j < 3; j++) {
            if (j < 2) {
                dfs(n, m, i + 1, i, temp, cs[j], cs[j]);
            } else {
                if (lastC == ' ') {
                    dfs(n, m, i + 1, lastNum, result, cs[j], c);
                } else {
                    dfs(n, m, i + 1, i, result, cs[j], c);
                }
            }
        }
    }

    private int doYunSuan(char c, int x, int y) {
        switch (c) {
            case '+':
                return x + y;
            case '-':
                return x - y;
        }
        return 0;
    }

}
