package simulationAqiyi0908.t2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            double result = getProbabiltyOfA(n, m);
            DecimalFormat df = new DecimalFormat("0.00000");
            System.out.println(df.format(result));
        }
    }

    private static double getProbabiltyOfA(int n, int m) {
        if (n <= 0) {
            return 0;
        }
        if (m <= 0) {
            return 1;
        }
        int sum = n + m;
        int tempN = n;
        int tempM = m;
        double result = n * 1.0 / sum;
        double temp = 1;
        while (tempN >= 0 && tempM >= 0) {
            temp *= 1.0 * tempM / sum;
            sum -= 1;
            tempM -= 1;

            temp *= 1.0 * tempM / sum;
            sum -= 1;
            tempM -= 1;

            temp *= 1.0 * tempN / sum;
            tempN -= 1;
            sum -= 1;

            if (sum > 0 && tempN > 0 && tempM >= 0) {
                result += 1.0 * tempN / sum * temp;
            }
        }

        sum = n + m;
        tempM = m;
        tempN = n;
        temp = 1;
        while (tempN >= 0 && tempM >= 0) {
            temp *= 1.0 * tempM / sum;
            sum -= 1;
            tempM -= 1;

            temp *= 1.0 * tempM / sum;
            sum -= 1;
            tempM -= 1;

            temp *= 1.0 * tempM / sum;
            tempM -= 1;
            sum -= 1;

            if (sum > 0 && tempN > 0 && tempM >= 0) {
                result += 1.0 * tempN / sum * temp;
            }
        }
        return result;
    }
}
