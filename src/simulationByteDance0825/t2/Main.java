package simulationByteDance0825.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int result = getResultOfN(n);
            System.out.println(result);
        }

    }

    private static int getResultOfN(int n) {
        int[] array = new int[501];
        array[1] = 1;
        array[2] = 2;
        array[3] = 5;
        array[4] = 14;
        for (int i = 2; i < n; i++) {
            array[i] = (array[i - 1] * 3 - 1) % 1000000007;
        }
        return array[n / 2];
    }
}
