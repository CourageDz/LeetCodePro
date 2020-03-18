package simulationTencent0920.t5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                arr2[i] = sc.nextInt();
            }

            int reuslt = getNumOfYH(arr1, arr2);
            System.out.println(reuslt);
        }
    }

    private static int getNumOfYH(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n = arr1.length;
        boolean ifOdd = true;
        if (n % 2 == 0) {
            ifOdd = false;
        }
        return 0;
    }
}
