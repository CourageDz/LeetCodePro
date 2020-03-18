package simulationXiaoMi0905.nearbyRetail;

import java.util.Scanner;

/***
 * 附近零售店
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            int[] miJias = new int[n];
            int[] miFans = new int[m];
            String[] miJs = sc.nextLine().trim().split(" ");
            String[] miFs = sc.nextLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                miJias[j] = Integer.parseInt(miJs[j]);
            }

            for (int j = 0; j < m; j++) {
                miFans[j] = Integer.parseInt(miFs[j]);
            }

            long result = getSumOfDistance(miJias, miFans);
            System.out.println(result);
        }
    }

    private static long getSumOfDistance(int[] miJias, int[] miFans) {
        long sum = 0;
        for (int i = 0; i < miFans.length; i++) {
            int p = miFans[i];
            sum += getDisOfMiJia(p, miJias);
        }
        return sum;
    }

    //该函数通过二分查找来寻找米粉所在位置的米家区间是哪两个，并返回该米粉距最近米家的距离
    private static int getDisOfMiJia(int p, int[] miJias) {
        int low = 0, high = miJias.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (high - low == 1) {
                int front = Math.abs(miJias[low] - p);
                int post = Math.abs(miJias[high] - p);
                return Math.min(front, post);
            } else if (p >= miJias[mid]) {
                low = mid;
            } else if (p <= miJias[mid]) {
                high = mid;
            }
        }
        return Integer.MAX_VALUE;
    }
}
