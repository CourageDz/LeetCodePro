package simultionMeiTuan.t1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            String[] array = s.split(" ");
            String result = getSerialOfArray(array);
            System.out.println(result);
        }
    }

    private static String getSerialOfArray(String[] array) {
        return "wertf";
    }


}
