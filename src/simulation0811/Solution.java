package simulation0811;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int k = sc.nextInt();
            int h = sc.nextInt();
            int[] goods = new int[k];
            int sum = 0;
            for (int i = 0; i < k; i++) {
                goods[i] = sc.nextInt();
                sum += goods[i];
            }
            int result = getMinRateOfGoods(goods, h, sum);
            System.out.println(result);
        }
    }

    private static int getMinRateOfGoods(int[] goods, int h, int sum) {
        int avg = (int) Math.floor(sum * 1.0 / h);
        boolean flag = false;
        int count = 0;
        while (!flag) {
            count = 0;
            for (int i = 0; i < goods.length; i++) {
                count += (int) Math.ceil(goods[i] * 1.0 / avg);
            }
            if (count <= h) {
                flag = true;
            } else {
                avg++;
            }
        }
        return avg;
    }

}
