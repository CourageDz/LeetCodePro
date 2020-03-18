package simulationALi0830.t2;

import java.util.Scanner;

public class Main {


    //    private static int count=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n, area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        if (n <= 5 || area == null || area.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
//            Queue<Integer> queue=new LinkedList<>();
//            boolean[][] ifVisit=new boolean[n][n];
            int count = dfs(0, i, area, n, 0);
            if (count < min) {
                min = count;
            }
        }
        return min;
    }

    private static int dfs(int i, int j, int[][] area, int n, int con) {
        if (i >= n) {
            return con;
        }
        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (i + 1 < n) {
            down = dfs(i + 2, j, area, n, con + area[i + 1][j]);
        }
        if (i != 0 && j + 2 < n) {
            right = dfs(i, j + 2, area, n, con + area[i][j + 1]);
        }
        return down < right ? down : right;
    }
}
