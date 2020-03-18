package simulation0815.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] array = new int[N + 1][M + 1];
            int count = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    array[i][j] = sc.nextInt();
                    count += array[i][j];
                }
            }
            int result = getSurfaceOfV(N, M, count * 6, array);
            System.out.println(result);
        }
    }

    private static int getSurfaceOfV(int n, int m, int all, int[][] array) {
        int di = 0;
        int ce = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (array[i][j] > 1) {
                    di += array[i][j] - 1;
                }
                for (int k = 0; k < 4; k++) {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    if (x >= 1 && x <= n && y >= 1 && y <= m) {
                        ce += Math.min(array[x][y], array[i][j]);
                    }
                }
            }
        }
        return all - ce - di * 2;
    }
}
