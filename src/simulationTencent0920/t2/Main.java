package simulationTencent0920.t2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Person {
        int num;
        int time;

        public Person(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            Person[] ps = new Person[n];
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                int num = sc.nextInt();
                ps[i] = new Person(k, num);
            }
            int result = getMinOfArr(ps);
            System.out.println(result);
        }
    }

    private static int getMinOfArr(Person[] ps) {
        int n = ps.length;
        Arrays.sort(ps, (a, b) -> {
            return a.time - b.time;
        });
        int low = 0, high = n - 1;
        int max = 0;
        while (low <= high) {
            int temp = 0;
            if (ps[low].num > 0) {
                temp = ps[low].time;
                ps[low].num--;
            } else {
                low++;
                continue;
            }

            if (ps[high].num > 0) {
                temp += ps[high].time;
                ps[high].num--;
            } else {
                high--;
                if (high > low) {
                    temp += ps[high].time;
                    ps[high].num--;
                } else {
                    break;
                }
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }


}
