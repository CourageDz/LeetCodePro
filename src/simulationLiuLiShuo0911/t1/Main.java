package simulationLiuLiShuo0911.t1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class LiWu {
        int a;
        int b;

        public LiWu(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            LiWu[] lws = new LiWu[n];
            for (int i = 0; i < n; i++) {
                int c = sc.nextInt();
                int d = sc.nextInt();
                lws[i] = new LiWu(c, d);
            }
            long result = getMoney(n, a, b, lws);
            System.out.println(result);
        }
    }

    private static long getMoney(int n, int a, int b, LiWu[] lws) {
        PriorityQueue<LiWu> queue = new PriorityQueue<>((t, l) -> {
            return Math.abs(l.b - l.a) - Math.abs(t.b - t.a);
        });
        for (int i = 0; i < lws.length; i++) {
            queue.offer(lws[i]);
        }
        long result = 0;
        while (!queue.isEmpty()) {
            LiWu lw = queue.poll();
            if (lw.a <= lw.b) {
                if (a > 0) {
                    result += lw.a;
                    a--;
                } else {
                    result += lw.b;
                    b--;
                }
            } else {
                if (b > 0) {
                    result += lw.b;
                    b--;
                } else {
                    result += lw.a;
                    a--;
                }
            }
        }
        return result;
    }
}
