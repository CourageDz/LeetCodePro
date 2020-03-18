package simulation0803.windows;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Window> windows = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Window[] ws = new Window[n];
            windows = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();
                int h = sc.nextInt();
                ws[i] = new Window(i + 1, x, y, w, h);
                windows.offerFirst(ws[i]);
            }
            for (int i = 0; i < m; i++) {
                int[] point = new int[2];
                point[0] = sc.nextInt();
                point[1] = sc.nextInt();
                int resulut = getWindowsOfPoint(point);
                System.out.println(resulut);
            }

        }
    }

    private static int getWindowsOfPoint(int[] point) {
        Iterator<Window> iterable = windows.iterator();
        while (iterable.hasNext()) {
            Window window = iterable.next();
            if (window.x <= point[0] && window.x + window.w >= point[0] && window.y <= point[1] && window.y + window.h >= point[1]) {
                iterable.remove();
                windows.offerFirst(window);
                return window.id;
            }
        }
        return -1;
    }

    static class Window {
        private int id;
        private int x;
        private int y;
        private int w;
        private int h;

        public Window(int id, int x, int y, int w, int h) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }
}
