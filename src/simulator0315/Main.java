package simulator0315;

import java.util.*;

public class Main {
    private int num = 0;

    public int getBaiFa(int n, int x, int y, int z) {
        Set<List<Integer>> results = new HashSet<>();
        int[] xNum = getNumArray(x, n);
        int[] yNum = getNumArray(y, n);
        int[] zNum = getNumArray(z, n);
        for (int i = 0; i < xNum.length; i++) {
            for (int j = 0; j < yNum.length; j++) {
                for (int k = 0; k < zNum.length; k++) {
                    if (xNum[i] + yNum[j] + zNum[k] == n) {
                        List<Integer> result = new ArrayList<>();
                        for (int l = 0; l < i; l++) {
                            result.add(x);
                        }
                        for (int l = 0; l < j; l++) {
                            result.add(y);
                        }
                        for (int l = 0; l < k; l++) {
                            result.add(z);
                        }
                        results.add(result);
                    }
                }
            }
        }
        for (List<Integer> result : results) {
            Integer[] nums = result.toArray(new Integer[result.size()]);
            permList(nums, 0);
        }
        return num;
    }

    public void permList(Integer[] result, int index) {
        if (index == result.length) {
            num++;
        }
        for (int i = index; i < result.length; i++) {
            if (i == index || result[index] != result[i]) {
                swap(result, i, index);
                permList(result, index + 1);
                swap(result, i, index);
            }
        }
    }

    public void swap(Integer[] result, int i, int j) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }

    public int[] getNumArray(int x, int n) {
        int num = n / x;
        int[] array = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            array[i] = x * i;
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        Main sol = new Main();
        System.out.println(sol.getBaiFa(n, x, y, z));
    }
}
