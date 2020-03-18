package simulation2015.test4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    class Combo {
        int tickets;
        int cost;
        double price;

        public Combo(int cost, int tickets) {
            this.tickets = tickets;
            this.cost = cost;
            this.price = cost * 1.0 / tickets;
        }
    }

    public static int sum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            Combo[] taoCans = new Combo[m];
            for (int i = 0; i < m; i++) {
                taoCans[i] = main.new Combo(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(taoCans, (a, b) -> {
                if (a.price - b.price < 0)
                    return -1;
                else if (a.price - b.price > 0)
                    return 1;
                else
                    return 0;
            });
            System.out.println(getMinCostOfTickets(n, taoCans, k));
        }
    }

    private static int getMinCostOfTickets(int n, Combo[] taoCans, int k) {
        return dfs(n + 1, taoCans, 0, k, 0);
    }

    private static int dfs(int n, Combo[] taoCans, int i, int k, int sum) {
        if (i == n) {
            return sum;
        }
        int left = n - i;
        int tempMax = Integer.MAX_VALUE;
        if (sum == Integer.MAX_VALUE)
            sum = 0;
        int sumCopy = sum;
        int buySingle = sum + k * left;
        for (int j = 0; j < taoCans.length; j++) {
            if (taoCans[j].tickets <= left) {
                tempMax = dfs(n, taoCans, i + taoCans[j].tickets, k, sumCopy + taoCans[j].cost);
                if (sum > tempMax || sum == 0)
                    sum = tempMax;
            }
        }
        if (buySingle < sum)
            return buySingle;
        else
            return sum;
    }
}
