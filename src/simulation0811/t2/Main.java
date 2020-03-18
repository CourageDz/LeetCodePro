package simulation0811.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                int m = sc.nextInt();
                int t = sc.nextInt();
                int m1 = sc.nextInt();
                int t1 = sc.nextInt();
                int m2 = sc.nextInt();
                int t2 = sc.nextInt();
                int result = getWaterOfT(m, t, m1, t1, m2, t2);
                System.out.println(result);
            }
        }
    }

    private static int getWaterOfT(int m, int t, int m1, int t1, int m2, int t2) {
        int count = 0;
        boolean flag1 = true, flag2 = true;
        for (int i = 1; i <= t; i++) {
            if (flag1 && flag2) {
                count += (m1 - m2);
                if (count >= m) {
                    count = m;
                } else if (count <= 0) {
                    count = 0;
                }
            } else if (!flag1 && flag2) {
                count -= m2;
                if (count <= 0) {
                    count = 0;
                }
            } else if (flag1 && !flag2) {
                count += m1;
                if (count >= m) {
                    count = m;
                }
            }
            if (i % t1 == 0) {
                flag1 = !flag1;
            }
            if (i % t2 == 0) {
                flag2 = !flag2;
            }
        }
        return count;
    }
}
