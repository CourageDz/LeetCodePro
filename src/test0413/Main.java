package test0413;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<String> resultList;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String dict = sc.nextLine();
        String ssplit = s.substring(4, s.length() - 1);
        String dictSplit = dict.substring(6);
        String[] items = dictSplit.split(",");
        String[] itemsTrimed = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            itemsTrimed[i] = items[i].substring(1, items[i].length() - 1);
        }
        List<String> result = main.getPossibleSentence(itemsTrimed, ssplit);
        System.out.print("[");
        for (int i = result.size() - 1; i >= 0; i--) {
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
            System.out.print(result.get(i));
            if (i != 0) {
                System.out.print(",");
            }
        }
        System.out.print("]");


    }

    private List<String> getPossibleSentence(String[] items, String s) {
        resultList = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        char[] ss = s.toCharArray();
        dfs(ss, items, 0, s.length(), sb);
        return resultList;
    }

    private void dfs(char[] s, String[] items, int i, int length, StringBuffer sb) {
        if (i == length) {
            resultList.add(sb.toString());
            return;
        }
        for (int j = 0; j < items.length; j++) {
            if (s[i] == items[j].charAt(0)) {
                boolean ok = true;
                for (int k = 1; k < items[j].length(); k++) {
                    if (s[i + k] != items[j].charAt(k)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    StringBuffer newSb = new StringBuffer(sb);
                    if (i != 0) {
                        newSb.append(" ");
                    }
                    newSb.append(items[j]);
                    dfs(s, items, i + items[j].length(), s.length, newSb);
                }

            }
        }
    }
}
