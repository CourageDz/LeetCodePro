package huaweiSimulation.getZhiShu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long num = sc.nextLong();
            list.clear();
            getZhiShuOfNum(num);
            for (int i = 0; i < list.size(); i++) {
                System.out.printf(list.get(i) + " ");
            }
        }
    }

    public static void getZhiShuOfNum(long num) {
        if (num <= 1) {
            return;
        }
        long sqrt = (long) Math.sqrt(num);
        boolean flag = false;
        for (long i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                flag = true;
                list.add(i);
                num /= i;
                getZhiShuOfNum(num);
                break;
            }
        }
        if (!flag) {
            list.add(num);
        }
    }
}
