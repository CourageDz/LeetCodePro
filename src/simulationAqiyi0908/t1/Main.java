package simulationAqiyi0908.t1;

import java.util.Scanner;

public class Main {
    private static int count = 0;
    private static int MAX = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 1; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            count = 0;
            getSerialsOfArr(n, arr);
            System.out.println(count);
        }
    }

    private static int getSerialsOfArr(int n, int[] arr) {
        if (arr == null || arr.length == 0 || n <= 1) {
            return 0;
        }
        boolean[] nums = new boolean[n + 1];
        for (int i = n; i >= 1; i--) {
            nums[i] = true;
            perm(arr, nums, i, 1, n);
            nums[i] = false;
        }

        return count;
    }

    private static void perm(int[] arr, boolean[] nums, int num, int index, int n) {
        if (index == n) {
            count = (count + 1) % MAX;
            return;
        }
        if (arr[index] == 1) {
            for (int i = num - 1; i >= 1; i--) {
                if (!nums[i]) {
                    nums[i] = true;
                    perm(arr, nums, i, index + 1, n);
                    nums[i] = false;
                }
            }
        } else {
            for (int i = num + 1; i <= n; i++) {
                if (!nums[i]) {
                    nums[i] = true;
                    perm(arr, nums, i, index + 1, n);
                    nums[i] = false;
                }
            }
        }
    }
}
