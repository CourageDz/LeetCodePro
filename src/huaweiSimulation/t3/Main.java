package huaweiSimulation.t3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            boolean result = getResultOfString(s);
            if (result) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    private static boolean getResultOfString(String s) {
        char[] array = s.toCharArray();
        LinkedList<Integer> num = new LinkedList<>();
        LinkedList<Character> symbol = new LinkedList<>();
        return dfs(array, 0, array.length - 1);
//        for (int i = 0; i <array.length ; i++) {
//            if(array[i]=='&'||array[i]=='|'||array[i]=='!'){
//                symbol.addLast(array[i]);
//            }else if(array[i]=='('){
//
//            }
//        }
    }

    private static boolean dfs(char[] array, int start, int end) {
        if (start == end) {
            if (array[start] == '1') {
                return true;
            } else if (array[start] == '0') {
                return false;
            }
        }
        if (start - end == 1 && array[start] == '!') {
            if (end == '1') {
                return false;
            } else {
                return true;
            }
        }
        if (start - end == 2) {

        }
        int l = start, r = end;

        while (l < r) {
            if (array[l] == '!') {

            }
        }
        for (int i = start; i <= end; i++) {

        }
        return false;
    }
}
