package jianZhiOffer.numArrayToMinString;

import java.util.Comparator;

public class Solution {
    private MyComparator com = new MyComparator();

    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String s3 = o1 + o2;
            String s4 = o2 + o1;
            return s3.compareTo(s4);
        }
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers.length == 1) {
            return String.valueOf(numbers[0]);
        }

        if (numbers == null)
            return null;

        quickSort(numbers, 0, numbers.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();

    }

    public int quickSort(int[] numbers, int start, int end) {
        if (start > end)
            return -1;

        int l = start;
        int r = end;
        int temp = numbers[start];
        while (l < r) {
            while (l < r && com.compare(String.valueOf(numbers[r]), String.valueOf(temp)) >= 0) {
                r--;
            }
            while (l < r && com.compare(String.valueOf(numbers[l]), String.valueOf(temp)) <= 0) {
                l++;
            }
            if (l < r) {
                int ts = numbers[l];
                numbers[l] = numbers[r];
                numbers[r] = ts;
            }
        }
        numbers[start] = numbers[r];
        numbers[r] = temp;
        quickSort(numbers, start, r - 1);
        quickSort(numbers, r + 1, end);
        return r;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] data3 = {3, 323, 32123};
        System.out.println(sol.PrintMinNumber(data3));
    }
}