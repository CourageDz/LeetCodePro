package simulationXieChen0904.t2;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        char[] array = expr.toCharArray();
        int n = array.length;
        LinkedList<Character> charQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = array[i];
            switch (c) {
                case '(':
                    charQueue.offerLast(c);
                    break;
                case ')':
                    boolean result = reverseString(charQueue);
                    if (!result) {
                        return "";
                    }
                    break;
                default:
                    charQueue.offerLast(c);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int l = charQueue.size();
        for (int i = 0; i < l; i++) {
            char c = charQueue.pollFirst();
            if (c == '(' || c == ')') {
                return "";
            }
            sb.append(c);
        }
        if (l == 0) {
            return "";
        } else {
            return sb.toString();
        }
    }

    private static boolean reverseString(LinkedList<Character> queue) {
        LinkedList<Character> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            char c = queue.pollLast();
            if (c == '(') {
                while (!list.isEmpty()) {
                    queue.offerLast(list.pollFirst());
                }
                return true;
            } else {
                list.offerLast(c);
            }
        }
        return false;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

