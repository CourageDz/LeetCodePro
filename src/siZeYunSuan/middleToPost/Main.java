package siZeYunSuan.middleToPost;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static LinkedList<Character> stack = new LinkedList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            sb.delete(0, sb.toString().length());
            stack.clear();
            String result = getPostOfS(s.toCharArray());
            System.out.println(result);
        }
    }

    private static String getPostOfS(char[] array) {
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            switch (c) {
                case '+':
                case '-':
                    getOper(c, 1);
                    break;
                case '*':
                case '/':
                    getOper(c, 2);
                    break;
                case '(':
                    stack.offerLast(c);
                    break;
                case ')':
                    gotParen();
                    break;
                default:
                    sb.append(c);
            }

        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    private static void gotParen() {
        while (!stack.isEmpty()) {
            char top = stack.pollLast();
            if (top == '(') {
                break;
            }
            sb.append(top);
        }
    }

    private static void getOper(char c, int prio) {
        while (!stack.isEmpty()) {
            char top = stack.pollLast();
            if (top == '(') {
                stack.offerLast(top);
                break;
            } else {
                int prio1;
                if (top == '+' || top == '-') {
                    prio1 = 1;
                } else {
                    prio1 = 2;
                }
                if (prio > prio1) {
                    stack.offerLast(top);
                    break;
                } else {
                    sb.append(top);
                }
            }
        }
        stack.offerLast(c);
    }
}
