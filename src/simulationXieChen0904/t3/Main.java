package simulationXieChen0904.t3;

import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/

    public static int schedule(int m, int[] array) {
        if (array == null || array.length == 0 || m < 1) {
            return -1;
        }
        int n = array.length;
        if (n < m) {
            int tempMax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                tempMax = Math.max(tempMax, array[i]);
            }
            return tempMax;
        } else {
            int sumMin = 0;
            int sumMax = 0;
            for (int i = 0; i < n; i++) {
                sumMax += array[i];
            }
            while (sumMin != sumMax - 1) {
                int mid = sumMin + (sumMax - sumMin) / 2;
//                int mid = (sumMin + sumMax) / 2;
                if (getSplitNum(array, mid) > m) {
                    sumMin = mid;
                } else {
                    sumMax = mid;
                }
            }
            return sumMax;
        }
    }


    public static int getSplitNum(int[] array, int max) {
        int count = 1;
        int tempSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                return Integer.MAX_VALUE;
            }
            tempSum += array[i];
            if (tempSum > max) {
                count++;
                tempSum = array[i];
            }
        }
        return count;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}

