package simulation2015.test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] starsMap = new int[1001][1001];
            int[][] starsCount = new int[1001][1001];
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                starsMap[x][y]++;
            }
            int m = in.nextInt();
            for (int i = 1; i < 1001; i++) {
                for (int j = 1; j < 1001; j++) {
                    starsCount[i][j] = starsMap[i][j] + starsCount[i - 1][j] + starsCount[i][j - 1] - starsCount[i - 1][j - 1];
                }
            }
            for (int i = 0; i < m; i++) {
                int lx = in.nextInt();
                int ly = in.nextInt();
                int rx = in.nextInt();
                int ry = in.nextInt();
                System.out.println(starsCount[rx][ry] - starsCount[lx - 1][ry] - starsCount[rx][ly - 1] + starsCount[lx - 1][ly - 1]);
            }
        }
    }


}
