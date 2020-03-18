package simulationDiDi.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine().trim();
            String[] items = s.split(" ");
            String result = getMinSerialOfString(items);
            System.out.println(result);
        }
    }

    private static String getMinSerialOfString(String[] array) {
        int l = array.length;
        StringBuilder sb = new StringBuilder();
        dfs(array, 0, l);
        for (int i = 0; i < l - 1; i++) {
            sb.append(array[i] + " ");
        }
        sb.append(array[l - 1]);
        return sb.toString();
    }

    private static void dfs(String[] array, int i, int n) {
        if (i >= n) {
            return;
        }
        int k = i - 1;
        if (k >= 1 && k + 2 <= n - 1 && (array[k].equals("+") || array[k].equals("*")) && !(array[k + 2].equals("*") && array[k].equals("+"))) {

            int num11 = Integer.parseInt(array[k - 1]);
            int num22 = Integer.parseInt(array[i]);
            String flag = array[k];
            if (num11 > num22) {
                String temp = array[i];
                array[i] = array[k - 1];
                array[k - 1] = temp;
                fdfs(array, k - 1, n, flag);
            }
        }
        dfs(array, i + 2, n);
    }

    private static void fdfs(String[] array, int k, int n, String flag) {
        if (k < 1) {
            return;
        }
        String flag2 = array[k - 1];
        if (k - 1 >= 1 && flag.equals(flag2)) {
            int num11 = Integer.parseInt(array[k - 2]);
            int num22 = Integer.parseInt(array[k]);
            if (num11 > num22) {
                String temp = array[k];
                array[k] = array[k - 2];
                array[k - 2] = temp;
                fdfs(array, k - 2, n, flag);
            } else {
                return;
            }
        } else {
            return;
        }
    }
}
