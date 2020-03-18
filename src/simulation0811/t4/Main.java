package simulation0811.t4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Moutain {
        int lmin;
        int rmin;
        int max;

        public Moutain(int lmin, int rmin, int max) {
            this.lmin = lmin;
            this.rmin = rmin;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] bases = new int[n];
            for (int i = 0; i < n; i++) {
                bases[i] = sc.nextInt();
            }

            ArrayList<Moutain> list = getMoutains(bases);
            int qn = sc.nextInt();
            for (int i = 0; i < qn; i++) {
                int h = sc.nextInt();
                int result = 0;
                if (n == 1) {
                    if (bases[0] > h) {
                        result = 1;
                    } else {
                        result = 0;
                    }
                } else {
                    result = getBaseSOfH(h, list);
                }
                System.out.println(result);
            }
        }
    }

    private static ArrayList<Moutain> getMoutains(int[] bases) {
        int lmin = Integer.MAX_VALUE;
        int rmin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;
        int n = bases.length;
        ArrayList<Moutain> list = new ArrayList<>();
        while (i < n) {
            if (lmin == Integer.MAX_VALUE) {
                lmin = bases[i];
                max = bases[i];
                i++;
                continue;
            }
            if (rmin == Integer.MAX_VALUE && bases[i] >= max) {
                max = bases[i];
                i++;
                continue;
            }
            if (rmin == Integer.MAX_VALUE && bases[i] < max) {
                while (i < n && bases[i] <= bases[i - 1]) {
                    i++;
                }
                rmin = bases[i - 1];
                Moutain moutain = new Moutain(lmin, rmin, max);
                list.add(moutain);
                lmin = bases[i - 1];
                max = Integer.MIN_VALUE;
                rmin = Integer.MAX_VALUE;
                i--;
            }
        }
        if (max != lmin) {
            Moutain moutain = new Moutain(lmin, lmin, max);
            list.add(moutain);
        }
        return list;
    }

    private static int getBaseSOfH(int h, ArrayList<Moutain> list) {
        int count = 0;
        for (Moutain m : list) {
            if (m.max <= h) {
                continue;
            } else if (m.lmin > h && m.rmin > h) {
                if (count == 0) {
                    count = 1;
                }
                continue;
            } else if (m.lmin <= h && m.rmin <= h && m.max > h) {
                count++;
                continue;
            } else if (m.lmin <= h && m.rmin > h && m.max > h) {
                count++;
                continue;
            } else if (m.lmin > h && m.max > h && m.rmin <= h) {
                continue;
            }
        }
        return count;
    }
}
