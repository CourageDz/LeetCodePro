package simulation2015.test1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int[] a = new int[3];
            for (int i = 0; i < 3; i++) {
                a[i] = in.nextInt();
            }
            int[] b = new int[3];
            for (int i = 0; i < 3; i++) {
                b[i] = in.nextInt();
            }
            DecimalFormat df = new DecimalFormat("0.0000");
            System.out.println(df.format(getProbablity(a, b)));
        }
    }

    private static double getProbablity(int[] a, int[] b) {
        int aSum = 0;
        int bSum = 0;
        int[] cars = new int[13];
        Arrays.fill(cars, 4);
        for (int i = 0; i < 3; i++) {
            cars[a[i] - 1]--;
            cars[b[i] - 1]--;
        }
        for (int i = 0; i < 3; i++) {
            aSum += a[i];
            bSum += b[i];
        }
        int sub = bSum - aSum;
        double pro = 0;
        for (int i = 1; i <= 13; i++) {
            int[] copyCars = Arrays.copyOf(cars, cars.length);
            pro += getProbablityOfStartAt(i, sub, copyCars);
        }

        return pro;
    }

    public static double getProbablityOfStartAt(int x, int d, int[] cars) {
        int leftCars = 52 - 6;
        int y = x + d;
        if (y >= 13)
            return 0;
        else if (y < 0) {
            y = 0;
        }
        int xCars = cars[x - 1];
        cars[x - 1]--;
        int yCars = 0;
        for (int i = y + 1; i <= 13; i++) {
            yCars += cars[i - 1];
        }
        double result = (xCars * 1.0) / leftCars * (yCars * 1.0 / (leftCars - 1));
        return result;
    }
}
