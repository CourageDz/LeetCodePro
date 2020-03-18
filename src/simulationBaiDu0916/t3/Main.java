package simulationBaiDu0916.t3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Route {
        int u;
        int v;
        int a;
        int b;
        int val;

        public Route(int u, int v, int a, int b) {
            this.u = u;
            this.v = v;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int fa = sc.nextInt();
            int fb = sc.nextInt();
            Route[] routes = new Route[M];
            PriorityQueue<Route> queue = new PriorityQueue<>((a, b) -> {
                return a.val - b.val;
            });
            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();
                int val = a * fa + b * fb;
                routes[i] = new Route(u, v, a, b);
                routes[i].val = val;
                queue.add(routes[i]);
            }
            int result = getMinOfRoutes(routes, fa, fb, N, queue);
        }
    }

    private static int getMinOfRoutes(Route[] routes, int fa, int fb, int n, PriorityQueue<Route> queue) {
        boolean[] ifVisit = new boolean[n];
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        if (!queue.isEmpty()) {
            Route r = queue.poll();
            ifVisit[r.v] = true;
            ifVisit[r.u] = true;
            minA = r.a;
            minB = r.b;
        }

        while (queue.isEmpty()) {

        }
        return 0;
    }


}
