package simulationTencent0920.t4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            ArrayList<Integer> list = getTermsOfArr(arr, k);
            for (int i = 0; i < k; i++) {
                System.out.println(list.get(i));
            }
        }
    }

    private static ArrayList<Integer> getTermsOfArr(int[] arr, int k) {
        int ind = 0;
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>(k);
        while (ind < n) {
            while (arr[ind] == 0 && ind < n) {
                ind++;
            }
            if (ind < n) {
                list.add(arr[ind]);
                if (list.size() == k) {
                    return list;
                }
                int temp = arr[ind];
                for (int i = ind; i < n; i++) {
                    arr[i] -= temp;
                    if (arr[i] < 0) {
                        arr[i] = 0;
                    }
                }
                ind++;
            }
        }
        if (list.size() != k) {
            int s = list.size();
            for (int i = s; i <= k; i++) {
                list.add(0);
            }
        }
        return list;
    }


}
