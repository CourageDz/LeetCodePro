package sortArrayTwoDir0506;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                arr[i] = temp;
            }
            int type = sc.nextInt();

            Main main = new Main();
            main.sortIntegerArray(arr, type);
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    System.out.print(arr[i]);
                } else {
                    System.out.print(" " + arr[i]);
                }
            }
        }
    }

    public void sortIntegerArray(int[] arr, int type) {
        int n = arr.length;
        sortArray(arr, 0, n - 1);
        if (type == 1) {
            for (int i = 0; i < n / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[n - 1 - i];
                arr[n - 1 - i] = temp;
            }
        }
    }

    public void sortArray(int[] arr, int start, int end) {
        int i = start, j = end;
        if (i < 0 || j >= arr.length || i >= j)
            return;
        int temp = arr[i];
        while (i < j) {
            while (j > i && arr[j] >= temp)
                j--;
            while (j > i && arr[i] <= temp)
                i++;
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[start] = arr[i];
        arr[i] = temp;
        sortArray(arr, start, j - 1);
        sortArray(arr, j + 1, end);
    }
}
