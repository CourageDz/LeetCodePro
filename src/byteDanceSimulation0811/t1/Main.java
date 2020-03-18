package byteDanceSimulation0811.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine().trim();
            String result = getPlain(s.toCharArray(), n, k);
            System.out.println(result);
        }
    }

    private static String getPlain(char[] array, int n, int k) {

        int[] plains = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = array[i];
            int num = c - '0';
            if (i < k - 1) {
                plains[i] ^= num;
                for (int j = i - 1; j >= 0; j--) {
                    plains[i] ^= plains[j];
                }
            } else {
                plains[i] ^= num;
                for (int j = i - 1; j >= i - 1 - k + 2; j--) {
                    plains[i] ^= plains[j];
                }
            }
            sb.append(plains[i]);
        }
        return sb.toString();
    }
}
