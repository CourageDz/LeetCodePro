package simulation2015.test3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();
            char[][] map = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                s = s.trim();
                map[i] = s.toCharArray();
            }
            System.out.println(getShortestRoadInPark(map));
        }
    }

    private static int getShortestRoadInPark(char[][] map) {
        int n = map.length;
        int minRoad = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '@') {
                    int road = getShortestRoad(i, j, map);
                    if (minRoad > road) {
                        minRoad = road;
                    }
                }
            }
        }
        return minRoad;
    }


    private static int getShortestRoad(int x, int y, char[][] map) {
        int n = map.length;
        int[][] bc = new int[n][n];
        boolean[][] tags = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(bc[i], 0);
            Arrays.fill(tags[i], false);
        }
        //右下左上
        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        int num = x * n + y;
        queue.offer(num);
        while (!queue.isEmpty()) {
            int cPoint = queue.poll();
            int tx = cPoint / n;
            int ty = cPoint % n;
            if (map[tx][ty] == '*') {
                return bc[tx][ty];
            }
            for (int i = 0; i < 4; i++) {
                int ttx = tx + dir[i][0];
                int tty = ty + dir[i][1];
                if (ttx >= 0 && ttx < n && tty >= 0 && tty < n) {
                    if (!tags[ttx][tty] && map[ttx][tty] != '#' && map[ttx][tty] != '@') {
                        tags[ttx][tty] = true;
                        bc[ttx][tty] = bc[tx][ty] + 1;
                        queue.offer(ttx * n + tty);
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
