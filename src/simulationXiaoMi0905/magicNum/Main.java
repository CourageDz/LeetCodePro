package simulationXiaoMi0905.magicNum;

import java.util.Scanner;

/***
 * 神奇数字
 */
public class Main {

    public static String getPass(int[] arr) {
        int line = 1, idx = line * line;
        if (arr == null || arr.length < 1) return "";
        StringBuilder sb = new StringBuilder();
        while ((idx = line * line) < arr.length) {
            sb.append(arr[idx - 1] + " ");
            line++;
        }
        sb.append(arr[arr.length - 1] + " ");
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            System.out.println(getPass(arr));
        }
    }
}
