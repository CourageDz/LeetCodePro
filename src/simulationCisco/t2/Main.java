package simulationCisco.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int result = getOriginJB(n);
            System.out.println(result);
        }
    }

    private static int getOriginJB(int n) {
        int num = 298;
        int count = 1;

        while (count < n) {
            int temp = num / 2;
            num = temp * 3;
            num--;
            if (num % 2 == 1) {
                num--;
            }
            count++;
        }
        return num;
    }
}
