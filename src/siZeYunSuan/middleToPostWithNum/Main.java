package siZeYunSuan.middleToPostWithNum;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static LinkedList<String> stack = new LinkedList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            String[] items = s.split(" ");
            sb.delete(0, sb.toString().length());
            stack.clear();
            String result = getPostOfS(items);
            System.out.println(result);
        }
    }

    private static String getPostOfS(String[] items) {
        int n = items.length;
        for (int i = 0; i < n; i++) {
            String cs = items[i];
            switch (cs) {
                case "+":
                case "-":
                    getOper(cs, 1);
                    break;
                case "*":
                case "/":
                    getOper(cs, 2);
                    break;
                case "(":
                    stack.offerLast(cs);
                    break;
                case ")":
                    getPar();
                    break;
                default:
                    sb.append(cs + " ");
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast() + " ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    private static void getPar() {
        while (!stack.isEmpty()) {
            String ls = stack.pollLast();
            if (ls.equals("(")) {
                break;
            }
            sb.append(ls + " ");
        }
    }

    private static void getOper(String cs, int prio) {
        while (!stack.isEmpty()) {
            String ls = stack.pollLast();
            if (ls.equals("(")) {
                stack.offerLast(ls);
                break;
            }
            int prio1;
            if (ls.equals("+") || ls.equals("-")) {
                prio1 = 1;
            } else {
                prio1 = 2;
            }
            if (prio > prio1) {
                stack.offerLast(ls);
                break;
            } else {
                sb.append(ls + " ");
            }
        }
        stack.offerLast(cs);
    }
}
