package jianZhiOffer.findTheNumberOfOneTimeOfArray;

public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int num = 0;
        int n = array.length;
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            num ^= array[i];
        }
        if (num == 0) {
            return;
        }
        int index = 0;
        while ((num & 1) == 0) {
            num >>= 1;
            index++;
        }
        int[] copyA = new int[n];
        int[] copyB = new int[n];
        int k1 = 0, k2 = 0;
        for (int i = 0; i < n; i++) {
            int temp = array[i];
            for (int j = 0; j < index; j++) {
                temp >>= 1;
            }
            if ((temp & 1) == 1) {
                copyA[k1++] = array[i];
            } else {
                copyB[k2++] = array[i];
            }
        }
        int temp1 = 0;
        for (int i = 0; i < k1; i++) {
            temp1 ^= copyA[i];
        }
        int temp2 = 0;
        for (int i = 0; i < k2; i++) {
            temp2 ^= copyB[i];
        }
        num1[0] = temp1;
        num2[0] = temp2;

    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        Solution sol = new Solution();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        sol.FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + "  " + num2[0]);
    }
}
