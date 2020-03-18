package simulationLiuLiShuo0911.t2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> matrix = new ArrayList<>();
        int m, n = 0;
        while (sc.hasNextLine()) {
            String[] items = sc.nextLine().trim().split(" ");
            n = items.length;
            List<Integer> array = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(items[i]);
                array.add(x);
            }
            matrix.add(array);
        }
        m = matrix.size();
        int result = getMinorLength(matrix, m, n);
        System.out.println(result);
        matrix.clear();
    }

    private static int getMinorLength(List<List<Integer>> matrix, int m, int n) {
        boolean[][] ifVisit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int flag = matrix.get(i).get(j);
                if (flag == 2) {
                    ifVisit[i][j] = true;
                    return dfs(i, j, ifVisit, m, n, matrix, 0);
                }
            }
        }
        return -1;
    }

    private static int dfs(int x, int y, boolean[][] ifVisit, int m, int n, List<List<Integer>> matrix, int count) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        if (x >= m || x < 0 || y >= n || y < 0) {
            return Integer.MAX_VALUE;
        }
        if (matrix.get(x).get(y) == 3) {
            return count;
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int xx = x + dirs[i][0];
            int yy = y + dirs[i][1];
            if (xx >= 0 && xx < m && yy >= 0 && yy < n) {
                if (!ifVisit[xx][yy] && matrix.get(xx).get(yy) != 1) {
                    ifVisit[xx][yy] = true;
                    int dis = dfs(xx, yy, ifVisit, m, n, matrix, count + 1);
                    ifVisit[xx][yy] = false;
                    if (dis < max) {
                        max = dis;
                    }
                }
            }
        }
        return max;
    }
}
