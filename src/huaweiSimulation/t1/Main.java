package huaweiSimulation.t1;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            String[] terms = s.split("@");
            String result = getCanUseChars(terms);
            System.out.println(result);
        }
    }

    private static String getCanUseChars(String[] terms) {
        boolean flag = false;
        if (terms.length == 1) {
            return terms[0] + "@";
        } else if (terms.length != 2) {
            return null;
        }
        String[] alls = terms[0].split(",");
        int[] arrays = new int[52];
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < alls.length; i++) {
            String[] ss = alls[i].split(":");
            char[] c = ss[0].toCharArray();
            if ('a' <= c[0] && c[0] <= 'z') {
                arrays[c[0] - 'a'] = Integer.valueOf(ss[1]);
            } else {
                arrays[c[0] - 'A' + 26] = Integer.valueOf(ss[1]);
            }
            if (!list.contains(c[0])) {
                list.addLast(c[0]);
            }

        }

        String[] uess = terms[1].split(",");
        for (int i = 0; i < uess.length; i++) {
            String[] ss2 = uess[i].split(":");
            char[] c2 = ss2[0].toCharArray();
            int num = Integer.valueOf(ss2[1]);
            if (num > 0) {
                flag = true;
            }
            if ('a' <= c2[0] && c2[0] <= 'z') {
                arrays[c2[0] - 'a'] -= num;
            } else {
                arrays[c2[0] - 'A' + 26] -= num;
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = list.iterator();
        while (iterator.hasNext()) {
            char cc = iterator.next();
            if ('a' <= cc && cc <= 'z') {
                if (arrays[cc - 'a'] > 0) {
                    sb.append(cc + ":" + arrays[cc - 'a'] + ",");
                }
            } else {
                if (arrays[cc - 'A' + 26] > 0) {
                    sb.append(cc + ":" + arrays[cc - 'A' + 26] + ",");
                }
            }
        }
        if (!flag) {
            sb.replace(sb.toString().length() - 1, sb.toString().length(), "@");
        } else {
            sb.replace(sb.toString().length() - 1, sb.toString().length(), "");
        }
        return sb.toString();
    }
}
