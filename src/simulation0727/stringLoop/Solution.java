package simulation0727.stringLoop;

public class Solution {
    public static void main(String[] args) {
        String[] array = {"ABC", "GHI", "JKL", "CEWRTG", "ISFAJ", "LSFDAS", "SDFASA"};
        if (sortStrings(array)) {
//            for (int i = 0; i <array.length ; i++) {
//                System.out.println(array[i]);
//            }
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean sortStrings(String[] array) {
        int n = array.length;
        if (n == 0 || array == null)
            return false;
        for (int i = 1; i < n; i++) {
            char last = array[i - 1].charAt(array[i - 1].length() - 1);
            for (int j = i; j < n; j++) {
                if (array[j].charAt(0) == last) {
                    swap(array, i, j);
                    break;
                } else if (j == n - 1) {
                    return false;
                }
            }
        }
        if (array[0].charAt(0) == array[n - 1].charAt(array[n - 1].length() - 1)) {
            return true;
        } else {
            return false;
        }

    }

    private static void swap(String[] array, int x, int y) {
        String temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
