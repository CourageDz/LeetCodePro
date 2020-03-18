package simulationByteDance0825.t1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[][] array = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
            int result = getTeamOfArray(array, n);
            System.out.println(result);
        }
    }

    private static int getTeamOfArray(int[][] array, int n) {
        boolean[] ifVisit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!ifVisit[i]) {
                count++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int p = queue.poll();
                    ifVisit[p] = true;
                    for (int j = 0; j < n; j++) {
                        if (!ifVisit[j] && array[j][p] >= 3) {
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}
