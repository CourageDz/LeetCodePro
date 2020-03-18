package simulator0315;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private int n;
    private int[] xyz = new int[3];

    private List<List<Integer>> results = new LinkedList<>();


    public Solution(int n, int x, int y, int z) {
        this.n = n;
        this.xyz[0] = x;
        this.xyz[1] = y;
        this.xyz[2] = z;
    }

    public int getBaiFa() {
        dfs(0, new LinkedList<>());
        return results.size();
    }

    public boolean dfs(int num, LinkedList<Integer> result) {
        if (num == n) {
            results.add(new LinkedList<>(result));
            return true;
        }
        if (num > n)
            return false;
        for (int i = 0; i < 3; i++) {
            if (i == 0 || xyz[i - 1] != xyz[i]) {
                num += xyz[i];
                result.offerLast(xyz[i]);
                dfs(num, result);
                num -= xyz[i];
                result.pollLast();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        Solution sol = new Solution(n, x, y, z);
        System.out.println(sol.getBaiFa());
//        sol.getBaiFa();
//        List<List<Integer>> results=sol.results;
//        for (int i = 0; i < results.size(); i++) {
//            List<Integer> result=results.get(i);
//            for (int j = 0; j <result.size(); j++) {
//                System.out.print(result.get(j)+" ");
//           }
//            System.out.println();
//        }
    }
}
