package simulator0314;

import java.util.Scanner;

public class Main2 {
    public int getXieXianNum(int x, int y, int k) {
        int result = 0;
        x = Math.abs(x);
        y = Math.abs(y);
        int min = x >= y ? y : x;
        if (k < min)
            return -1;
        else if (k == min && (k < y || k < x))
            return -1;
        result = min;
        k -= min;
        x -= min;
        y -= min;
        if (x == 0 && y == 0) {
            if (k % 2 == 0)
                return result + k;
            else
                return result - 2 + k;
        } else if (x == 0) {
            int temp = k - y;
            return result + temp;
        } else {
            int temp = k - x;
            if (temp % 2 == 1)
                return result + temp - 1;
            else {
                return result + temp;
            }
        }
    }

    public static void main(String[] args) {
        Main2 test = new Main2();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int k = in.nextInt();
            result[i] = test.getXieXianNum(x, y, k);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
