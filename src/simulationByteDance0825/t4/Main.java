package simulationByteDance0825.t4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int result = getMaxTGofArray(array);
            System.out.println(result);
        }
    }

    private static int getMaxTGofArray(int[] array) {
        int n = array.length;

        boolean[] ifVisit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            if (!ifVisit[i]) {
                queue.add(i);
                ifVisit[i] = true;
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    count++;
                    int candy = array[index];
                    for (int j = 0; j < n; j++) {
                        if (!ifVisit[j] && hasGongYueShu(candy, array[j])) {
                            ifVisit[j] = true;
                            queue.add(j);
                        }
                    }
                }
                if (count > max) {
                    max = count;
                }
                if (n - max < max) {
                    return max;
                }
            }
        }
        return max;
    }

    private static boolean hasGongYueShu(int num1, int num2) {
        while (num1 != num2) {
            int max = Math.max(num1, num2);
            int min = Math.min(num1, num2);
            num1 = max - min;
            num2 = min;
        }
        if (num1 == 1) {
            return false;
        } else {
            return true;
        }
    }
}
