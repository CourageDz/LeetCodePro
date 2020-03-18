package simulationQiAnXin0909.t1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] items = sc.nextLine().trim().split(" ");
            int n = items.length;
            int[] pids = new int[n];
            for (int i = 0; i < n; i++) {
                pids[i] = Integer.parseInt(items[i]);
            }

            items = sc.nextLine().trim().split(" ");
            int[] ppids = new int[n];
            for (int i = 0; i < n; i++) {
                ppids[i] = Integer.parseInt(items[i]);
            }
            int num = Integer.parseInt(sc.nextLine().trim());
            int result = getNumberOfThreads(num, pids, ppids);
            System.out.println(result);
        }
    }

    private static int getNumberOfThreads(int num, int[] pids, int[] ppids) {
        if (pids == null || ppids == null || pids.length == 0 || ppids.length == 0 || num < 1) {
            return 0;
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < pids.length; i++) {
            if (num == pids[i]) {
                queue.offerLast(num);
                break;
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int pid = queue.pollFirst();
            count++;
            for (int i = 0; i < ppids.length; i++) {
                if (ppids[i] == pid) {
                    queue.offerLast(pids[i]);
                }
            }
        }
        return count;
    }
}
