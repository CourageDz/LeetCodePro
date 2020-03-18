package simulation0815.t5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int L = sc.nextInt();
            Pot[] pots = new Pot[n];
            for (int i = 0; i < n; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                pots[i] = new Pot(l, r);
            }
            int result = getMinPotsOfRiver(L, pots);
            System.out.println(result);
        }
    }

    static class Pot {
        int start;
        int end;

        public Pot(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int getMinPotsOfRiver(int l, Pot[] pots) {
        ArrayList<Pot> list = new ArrayList<>(Arrays.asList(pots));
        Collections.sort(list, (a, b) -> {
            if (a.start < b.start) {
                return -1;
            } else if (a.start > b.start) {
                return 1;
            } else {
                if (a.end > b.end) {
                    return -1;
                } else if (a.end < b.end) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int count = 0;
        int k = 0;
        for (Pot pot : list) {
            if (k >= pot.end) {
                continue;
            } else if (k >= pot.start) {
                count++;
                k = pot.end;
            } else {
                return -1;
            }
            if (k >= l) {
                break;
            }
        }
        return count;
    }
}
