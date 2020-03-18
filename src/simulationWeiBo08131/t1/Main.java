package simulationWeiBo08131.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] items = s.split(",");
            int n = Integer.parseInt(items[0]);
            String result = getMinorVersion(n, items);
            System.out.println(result);
        }
    }

    private static String getMinorVersion(int n, String[] items) {
        String min = items[1].trim();
        for (int i = 2; i <= n; i++) {
            min = compare(min, items[i].trim());
        }
        return min;
    }

    private static String compare(String min, String item) {
        String[] items1 = min.split("\\.");
        String[] items2 = item.split("\\.");

        int i1 = 0, n1 = items1.length, n2 = items2.length;
        while (i1 < n1 && i1 < n2) {
            if (items1[i1].equals(items2[i1])) {
                i1++;
            } else {
                Integer num1 = Integer.parseInt(items1[i1]);
                Integer num2 = Integer.parseInt(items2[i1]);
                if (num1 < num2) {
                    return min;
                } else {
                    return item;
                }
            }
        }
        return "";
    }
}
