package simulation0811.t1;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                int n = sc.nextInt();
                int[] array = new int[n];
                for (int j = 0; j < n; j++) {
                    array[j] = sc.nextInt();
                }
                int result = getTypeOfArray(array);
                System.out.println(result);
            }
        }
    }

    private static int getTypeOfArray(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int count = getOneOfNumber(array[i]);
            set.add(count);
        }
        return set.size();
    }

    private static int getOneOfNumber(int num) {
        int count = 0;
        while (num != 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }
}
