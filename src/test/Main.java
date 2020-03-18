package test;


import java.util.Scanner;

public class Main {
//    static class Cons{
//        int
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] cons = new int[m][2];
            for (int i = 0; i < m; i++) {
                cons[i][0] = sc.nextInt();
                cons[i][1] = sc.nextInt();
            }
            int result = getMaxRubbish(n, cons);
            System.out.println(result);
        }
    }

    private static int getMaxRubbish(int n, int[][] cons) {
        int[] flag = new int[n];
        int count = 1;
        for (int i = 0; i < cons.length; i++) {
            int x = cons[i][0];
            int y = cons[i][1];
            if (flag[x] != 0 && flag[y] != 0 && flag[x] == flag[y]) {
                flag[y] = 3;
            }
        }
        return 0;
    }
}
