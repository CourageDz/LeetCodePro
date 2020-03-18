package simulation0803.t1;

import java.util.Scanner;

public class Main {
    private static int mfoots = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.println(getMaxFoots(map, k));
        }
    }

    private static int getMaxFoots(int[][] map, int k) {
        int n = map.length;
        int m = map[0].length;
        int maxX = 0, maxY = 0, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > max) {
                    max = map[i][j];
                    maxX = i;
                    maxY = j;
                }
            }
        }
        return dfs(maxX, maxY, map, k);

    }

    private static int dfs(int x, int y, int[][] map, int k) {
        int n = map.length;
        int m = map[0].length;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        if (x < 0 || x >= n || y < 0 || y >= m) {
            return 0;
        }
        int maxCount = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            int count = dfs(xx, yy, map, k);
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return maxCount + 1;
    }

}
