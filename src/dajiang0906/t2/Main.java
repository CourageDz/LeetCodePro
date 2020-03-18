package dajiang0906.t2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine().trim();
                String[] terms = s.split(" ");
                map.put(terms[0], terms[1]);
            }

            for (int i = 0; i < m; i++) {
                String s2 = sc.nextLine().trim();
                String result = map.get(s2);
                System.out.println(result);
            }
        }
    }


}
