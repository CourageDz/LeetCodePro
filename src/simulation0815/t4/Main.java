package simulation0815.t4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int[] view = getViewOfTall(n, array);
            for (int i = 0; i < n - 1; i++) {
                System.out.printf(view[i] + " ");
            }
            System.out.println(view[n - 1]);
        }
    }

    private static int[] getViewOfTall(int n, int[] array) {
        int[] views = new int[n];
        Arrays.fill(views, 1);
        return views;
    }
}
