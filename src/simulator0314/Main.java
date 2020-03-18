package simulator0314;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public Map<Integer, Character> jiajianerchashu(int n, int k) {
        Map<Integer, Character> results = new LinkedHashMap<>();
        results.put(1, '+');
        int sum = 1;
        if (dfs(1, 1, k, n, sum, results))
            return results;
        else {
            results.put(1, '-');
            sum = -1;
            if (dfs(1, 1, k, n, sum, results))
                return results;
        }
        return null;
    }

    public boolean dfs(int num, int deep, int k, int n, int sum, Map<Integer, Character> results) {
        if (deep == k && sum == n) {
            return true;
        }
        deep++;
        if (deep > k)
            return false;
        for (int i = 0; i < 2; i++) {
            int temp = 2 * num + i;
            sum += temp;
            results.put(temp, '+');
            if (dfs(temp, deep, k, n, sum, results))
                return true;
            sum -= 2 * temp;
            results.put(temp, '-');
            if (dfs(temp, deep, k, n, sum, results))
                return true;
            sum += temp;
            results.remove(temp);
        }
        return false;
    }


    public static void main(String[] args) {
        Main test = new Main();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            Map<Integer, Character> results = test.jiajianerchashu(n, k);
            for (Map.Entry<Integer, Character> item : results.entrySet()) {
                System.out.println(item.getKey() + " " + item.getValue());
            }
        }
    }
}
