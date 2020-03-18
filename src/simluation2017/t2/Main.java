package simluation2017.t2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] maps = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                s.trim();
                maps[i] = s.toCharArray();
            }
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int k = sc.nextInt();
            int[][] dirs = new int[k][2];
            for (int i = 0; i < k; i++) {
                dirs[i][0] = sc.nextInt();
                dirs[i][1] = sc.nextInt();
            }
            System.out.println(getMaxRoadInDiLao(sx, sy, maps, dirs));
        }
    }

    public static int getMaxRoadInDiLao(int sx, int sy, char[][] maps, int[][] dirs) {
        int n = maps.length;
        int m = maps[0].length;
        int k = dirs.length;
        boolean[][] isVisited = new boolean[n][m];
        int[][] roads = new int[n][m];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(sx * n + sy);
        isVisited[sx][sy] = true;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int ssx = num / n;
            int ssy = num % n;
            for (int i = 0; i < k; i++) {
                int nx = ssx + dirs[i][0];
                int ny = ssy + dirs[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        if (maps[nx][ny] == '.') {
                            roads[nx][ny] = roads[ssx][ssy] + 1;
                            queue.offer(nx * n + ny);
                        }
                    }
                }
            }
        }
        if (roads[n - 1][m - 1] != 0) {
            return roads[n - 1][m - 1];
        } else {
            return -1;
        }
    }
}
