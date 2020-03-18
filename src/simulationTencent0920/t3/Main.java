package simulationTencent0920.t3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int T = sc.nextInt();
            int[] arr = new int[T];
            for (int j = 0; j < T; j++) {
                arr[j] = sc.nextInt();
            }
            int[] result = aveArray(arr);
            if (result == null) {
                System.out.println();
            }
            System.out.println(result[0] + " " + result[1]);
        }
    }

    private static int[] aveArray(int[] arr) {
        int sum1 = 0, sum2 = 0;
        int[] res = new int[2];
        if (arr == null || arr.length == 0)
            return null;
        int ind = 0;
        Arrays.sort(arr);
        int n = arr.length;
        while (ind < n) {
            if (sum1 > sum2) {
                sum1 += arr[ind++];
                if (ind < n) {
                    sum2 += arr[ind++];
                }
            } else {
                sum2 += arr[ind++];
                if (ind < n) {
                    sum1 += arr[ind++];
                }
            }
        }
        if (sum1 <= sum2) {
            res[0] = sum1;
            res[1] = sum2;
        } else {
            res[0] = sum2;
            res[1] = sum1;
        }
        return res;
    }
}
