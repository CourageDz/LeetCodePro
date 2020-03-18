package jianZhiOffer.perm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public ArrayList<String> Permutation(String str) {
        int n = str.length();
        char[] charss = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        perm(charss, 0, n, list);
        Collections.sort(list);
        return list;
    }

    public void perm(char[] charss, int l, int r, ArrayList<String> list) {
        if (l == r - 1) {
            list.add(String.valueOf(charss));

            return;
        } else {
            for (int i = l; i < r; i++) {
                if (i != l && charss[i] == charss[i - 1]) {
                    continue;
                } else {
                    swap(i, l, charss);
                    perm(charss, l + 1, r, list);
                    swap(i, l, charss);
                }
            }
        }
    }

    public void swap(int l, int r, char[] charss) {
        char temp = charss[l];
        charss[l] = charss[r];
        charss[r] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> res = sol.Permutation("aabc");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
