package alg839;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int numSimilarGroups(String[] A) {
        int n = A.length;
        int W = A[0].length();
        DSU dsu = new DSU(n);
        if (n < W * W) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isSimilar(A[i], A[j]))
                        dsu.union(i, j);
                }
            }
        } else {
            Map<String, List<Integer>> elementMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char[] elements = A[i].toCharArray();
                for (int j = 0; j < elements.length; j++) {
                    for (int k = j + 1; k < elements.length; k++) {
                        swap(elements, j, k);
                        StringBuffer sb = new StringBuffer();
                        sb.append(elements);
                        elementMap.computeIfAbsent(sb.toString(), x -> new ArrayList<>()).add(i);
                        swap(elements, j, k);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (elementMap.containsKey(A[i])) {
                    for (int k : elementMap.get(A[i]))
                        dsu.union(k, i);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i)
                count++;
        }
        return count;
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean isSimilar(String a, String b) {
        int n = a.length();
        if (n != b.length())
            return false;
        int index[] = new int[3];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i))
                index[count++] = i;
            if (count == 3)
                return false;
        }
        return true;
    }


    class DSU {
        int[] parents;

        public DSU(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if (parents[x] != x)
                parents[x] = find(parents[x]);
            return parents[x];
        }

        public void union(int x, int y) {
            parents[find(x)] = find(y);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String A[] = {"tars", "rats", "arts", "star"};
        int result = sol.numSimilarGroups(A);
        System.out.println(result);
    }
}
