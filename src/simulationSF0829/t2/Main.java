package simulationSF0829.t2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            boolean[][] abilitie = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                int num = sc.nextInt();
                int lan = sc.nextInt();
                abilitie[num - 1][lan - 1] = true;
            }
            int result = getMinJiQiOfPersons(n, m, abilitie);
            System.out.println(result);
        }
    }

    private static int getMinJiQiOfPersons(int n, int m, boolean[][] abilitie) {
        int[] rela = new int[n];
        for (int i = 0; i < n; i++) {
            rela[i] = i;
        }
        int[] firstNum = new int[m];
        Arrays.fill(firstNum, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (abilitie[j][i] == true) {
                    firstNum[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (firstNum[i] == -1) {
                continue;
            }
            for (int j = firstNum[i] + 1; j < n; j++) {
                if (abilitie[j][i] == true) {
                    union(firstNum[i], j, rela);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < rela.length; i++) {
            if (rela[i] == i) {
                count++;
            }
        }
        if (count == 1) {
            return 1;
        } else {
            return count - 1;
        }
    }

    private static void union(int p, int q, int[] rela) {
        int pID = find(p, rela);
        int qID = find(q, rela);
        if (pID == qID) return;
        for (int i = 0; i < rela.length; i++)
            if (rela[i] == pID) rela[i] = qID;
    }

    private static int find(int i, int[] rela) {
        while (i != rela[i]) {
            i = rela[i];
        }
        return i;
    }
}
