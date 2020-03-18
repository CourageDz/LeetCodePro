package simulationALi0830;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            ArrayList<ArrayList<Integer>> lists = getSubArray(n, array);
        }
    }

    private static ArrayList<ArrayList<Integer>> getSubArray(int n, int[] array) {

        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, array, n, list);
        return lists;
    }

    private static void dfs(int i, int[] array, int n, ArrayList<Integer> list) {
        if (i == n) {

        }
    }
}
