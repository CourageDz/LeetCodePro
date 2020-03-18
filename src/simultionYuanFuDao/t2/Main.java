package simultionYuanFuDao.t2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int[] array = new int[k];
            for (int j = 0; j < k; j++) {
                array[j] = sc.nextInt();
            }
            Arrays.sort(array);
            long result = 0;
            if (k >= 3) {
                result = getTeamOfRoles(array, k);
            }
            System.out.println(result);
        }
    }

    private static long getTeamOfRoles(int[] array, int k) {
        long count = 0;
        for (int i = 2; i < k; i++) {
            if (array[i - 2] == 0) {
                continue;
            }
            count += array[i - 2];
            array[i - 1] -= array[i - 2];
            array[i] -= array[i - 2];
        }
        return count;
    }
}
