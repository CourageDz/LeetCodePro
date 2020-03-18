package simulator0220;

import java.util.Scanner;

public class Solution {
    public int existDays(int x, int f, int d, int p) {
        int d1 = d / x;
        int days = 0;
        if (f > d1) {
            return d1;
        } else {
            days = f;
            d = d - f * x;
            days += d / (p + x);
            return days;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, f, d, p;
        x = sc.nextInt();
        f = sc.nextInt();
        d = sc.nextInt();
        p = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.existDays(x, f, d, p));
    }
}
