package simulator0220;

import java.util.Scanner;

public class Main {
    public boolean existInHotDays(int day, int A, int B, int C) {
        int d1 = 0;
        if (C / 2 != 0) {
            d1 += C / 2;
            C = C % 2;
        }
        if (B / 3 != 0) {
            d1 += B / 3;
            B = B % 3;
        }
        if (C != 0 && B != 0 && A > 0) {
            if (C == 1 && B == 2 && A >= 5) {
                d1 += 2;
                A -= 5;
            } else {
                A -= 1;
                d1 += 1;
            }
        } else if (C != 0 && A >= 3) {
            A -= 3;
            d1 += 1;
        } else if (B != 0 && A > 6 - 2 * B) {
            A -= 6 - 2 * B;
            d1 += 1;
        }
        if (A >= 6) {
            d1 += A / 6;
        }
        if (d1 >= day)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] results = new boolean[n];
        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            results[i] = main.existInHotDays(day, A, B, C);
        }
        for (int i = 0; i < n; i++) {
            if (results[i])
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
