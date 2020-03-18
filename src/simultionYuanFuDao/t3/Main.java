package simultionYuanFuDao.t3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            sc.nextLine();
            String origin = sc.nextLine().trim();
            String target = sc.nextLine().trim();
            int result = getMethodOfTransform(origin.toCharArray(), target.toCharArray(), N, M, K);
            System.out.println(result);
        }
    }

    private static int getMethodOfTransform(char[] origin, char[] target, int n, int m, int k) {
        int result = dfs(origin, target, n, 0, m, k);
        return 1;
    }

    private static int dfs(char[] origin, char[] target, int n, int c, int m, int k) {
        for (int i = 0; i < n - k; i++) {
            for (int j = 0; j < k; j++) {

            }
        }
        return 0;
    }

}
