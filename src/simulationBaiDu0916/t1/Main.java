package simulationBaiDu0916.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long k = sc.nextLong();
            int result = getMinOfNM(n, m, k);
            System.out.println(result);
        }
    }

    private static int getMinOfNM(int n, int m, long k) {
        if (n <= 0 || m <= 0 || k <= 0) {
            return -1;
        }
        if (n * m <= k) {
            return 0;
        }

        int max = Math.max(m, n);
        int min = Math.min(m, n);
        int lmin = (int) k / max;
        if (lmin != 0) {
            return min - lmin;
        } else {
            int lmax = max - (int) k;
            return min - (lmin + 1) + lmax;
        }
    }
}
