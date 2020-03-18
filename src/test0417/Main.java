package test0417;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Set<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            String s = sc.nextLine();
            String[] items = s.split(" ");
            for (int j = 0; j < items.length; j++) {
                set.add(Integer.valueOf(items[j]));
            }
            arrays.add(set);
        }
        main.getCombineSets(arrays);
        int max = 0;
        for (int i = 0; i < arrays.size(); i++) {
            if (max < arrays.get(i).size())
                max = arrays.get(i).size();
        }
        System.out.println(arrays.size());
        System.out.println(max);
    }

    public List<Set<Integer>> getCombineSets(List<Set<Integer>> arrays) {
        while (true) {
            int n = arrays.size();
            dfs(arrays, 0, arrays.size());
            if (arrays.size() == n)
                break;
        }
        return arrays;
    }

    private void dfs(List<Set<Integer>> arrays, int i, int size) {
        if (i == size)
            return;
        Set<Integer> set = arrays.get(i);
        boolean isHasSame = true;
        for (int k = i - 1; k >= 0; k--) {
            Set<Integer> lastSet = arrays.get(k);
            if (isHasSameNum(set, lastSet)) {
                lastSet.addAll(set);
                arrays.remove(i);
                isHasSame = false;
                break;
            }
        }
        if (isHasSame) {
            dfs(arrays, i + 1, size);
        } else {
            dfs(arrays, i, size - 1);
        }
    }

    private boolean isHasSameNum(Set<Integer> a, Set<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            for (Integer x : b) {
                if (a.contains(x))
                    return true;
            }
        }
        return false;
    }
}
