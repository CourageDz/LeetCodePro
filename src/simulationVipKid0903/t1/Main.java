package simulationVipKid0903.t1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().trim().split(",");
            int n = s.length;
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(s[i].trim());
            }
            int result = getPairOfArray(array);
            System.out.println(result);
        }
    }

    private static int getPairOfArray(int[] array) {
        Arrays.sort(array);
        int n = array.length;
        int start = 0, end = n - 1;
        int count = 0;
        while (start < end) {
            if (array[start] + array[end] > 0) {
                end--;
            } else if (array[start] + array[end] < 0) {
                start++;
            } else {
                count++;
                start++;
                end--;
            }
        }
        return count;
    }
}
