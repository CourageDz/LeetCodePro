package simulation0727.t1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            ArrayList<String> res = classifyRepeatChars(s);
            for (String ss : res) {
                System.out.println(ss);
            }
        }
    }

    public static ArrayList<String> classifyRepeatChars(String s) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char[] array = s.toCharArray();
        int[] num = new int[26];
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'a' && array[i] <= 'z') {
                num[array[i] - 'a']++;
            } else if (array[i] >= 'A' && array[i] <= 'Z') {
                num[array[i] - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (num[i] == 1) {
                sb1.append((char) ('a' + i));
            } else if (num[i] > 1) {
                sb2.append((char) ('a' + i));
            }
        }
        ArrayList<String> list = new ArrayList<>();
        list.add(sb2.toString());
        list.add(sb1.toString());
        return list;
    }
}
