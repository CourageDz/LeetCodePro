package heapSort;

public class Solution {
    public void sift(int[] arr, int low, int high) {
        int i = low;
        int j = 2 * i;
        int temp = arr[i];
        while (j <= high) {
            if (j < high && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
                j = 2 * i;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public void sort(int[] arr, int n) {
        int temp;
        for (int j = n / 2; j >= 1; j--) {
            sift(arr, j, n);
        }
        for (int j = n; j >= 1; j--) {
            temp = arr[1];
            arr[1] = arr[j];
            arr[j] = temp;
            sift(arr, 1, n - 1);
        }
    }
}
