package test0412;

import java.util.Scanner;

public class Main {
    private int count;

    public int getRoutesResult(int x, int y) {
        count = 0;
        dfs(x, y, 0, 0);
        return count;
    }

    public void dfs(int x, int y, int ix, int iy) {
        if (ix == x && iy == y) {
            count++;
            return;
        }
        if (ix < x) {
            dfs(x, y, ix + 1, iy);
        }
        if (iy < y) {
            dfs(x, y, ix, iy + 1);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(main.getRoutesResult(x, y));
    }
}
