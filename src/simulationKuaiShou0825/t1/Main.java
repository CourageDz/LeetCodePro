package simulationKuaiShou0825.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int k = sc.nextInt();
                boolean result = getResultOfK(k, 0);
                System.out.println(result);
            }
        }

    }

    private static boolean getResultOfK(int k, int count) {
        if (k == 1) {
            return true;
        }
        if (count >= 10) {
            return false;
        }
        int result = 0;
        while (k != 0) {
            int temp = k % 10;
            k /= 10;
            result += Math.pow(temp, 2);
        }
        return getResultOfK(result, count + 1);
    }
}
