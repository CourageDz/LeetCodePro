package simultionMeiTuan.t3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            ArrayList<Integer> list = getResultOfChars(s.toCharArray());
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.printf(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }
    }

    private static ArrayList<Integer> getResultOfChars(char[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = array.length;
        if (n <= 0 || array == null) {
            return list;
        }
        int i = 0;
        while (i < n) {
            i = getPianDuanOfChars(list, array, i, 0);
        }
        return list;
    }

    public static int getPianDuanOfChars(ArrayList<Integer> list, char[] array, int ind, int count) {
        int n = array.length;
        if (ind >= n) {
            list.add(count);
            return n;
        }
        int[] index = new int[26];
        Arrays.fill(index, -1);
        int start = ind;
        int end = -1;
        char c = array[start];
        for (int i = n - 1; i > start; i--) {
            if (array[i] == c) {
                end = i;
                break;
            }
        }

        if (end != -1) {
            for (int i = start; i <= end; i++) {
                index[array[i] - 'A'] = i;
            }
            int max = end;
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = end + 1; i < n; i++) {
                    if (index[array[i] - 'A'] != -1) {
                        max = i;
                        index[array[i] - 'A'] = i;
                        flag = true;
                    }
                }
                if (flag) {
                    for (int i = end + 1; i <= max; i++) {
                        index[array[i] - 'A'] = i;
                    }
                }
                end = max;
            }
            if (max != start) {
                list.add(max - start + 1 + count);
            }
            return max + 1;
        } else {
            return getPianDuanOfChars(list, array, ind + 1, count + 1);
        }
    }
}
