package simulationTencent0920.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < n; i++) {
                int l = Integer.parseInt(sc.nextLine().trim());
                char[] arr = sc.nextLine().trim().toCharArray();
                boolean result = getPossibleOfArr(l, arr);
                if (result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean getPossibleOfArr(int l, char[] arr) {
        int index = 0;
        if (arr.length != l) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '8') {
                index = i;
                break;
            }
        }
        int len = arr.length - index;
        return len >= 11 ? true : false;
    }
}
