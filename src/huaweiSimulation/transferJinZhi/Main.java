package huaweiSimulation.transferJinZhi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            s = s.substring(2);
            char[] array = s.toCharArray();
            int result = getTenOfNum(array);
            System.out.println(result);
        }
    }

    public static int getTenOfNum(char[] array) {
        int result = 0;
        int n = array.length;
        int k = 0, num = 0;
        for (int i = n - 1; i >= 0; i--) {
            if ('0' <= array[i] && array[i] <= '9') {
                int val = array[i] - '0';
                num += Math.pow(16, k) * val;
            } else {
                int val = array[i] - 'A' + 10;
                num += Math.pow(16, k) * val;
            }
            k++;
        }
        return num;
    }
}
