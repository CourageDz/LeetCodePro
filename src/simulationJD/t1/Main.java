package simulationJD.t1;

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
            int result = getMaxTeamsOfArray(array);
            System.out.println(result);
        }
    }

    private static int getMaxTeamsOfArray(int[] array) {
        int n = array.length;
        int count = 0;
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        int start = 0;
        while (start < n) {
            if (copy[start] == array[start]) {
                count++;
                start++;
            } else {
                for (int i = start + 1; i < n; i++) {
                    if (copy[start] == array[i]) {
                        start = i + 1;
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
