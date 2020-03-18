package simulationBaiDu0916.t2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] roads = new int[m][2];
            for (int j = 0; j < m; j++) {
                roads[j][0] = sc.nextInt();
                roads[j][1] = sc.nextInt();
            }
            boolean result = getResultOfToTarget(n, m, roads);
            if (result) {
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean getResultOfToTarget(int n, int m, int[][] roads) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (roads[i][0] == 1) {
                queue.add(roads[i][1]);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            if (count > 2) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int p = queue.poll();
                for (int j = 0; j < m; j++) {
                    if (roads[j][0] == p) {
                        queue.add(roads[j][1]);
                    }
                    if (p == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
