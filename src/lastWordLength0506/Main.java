package lastWordLength0506;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result;
        result = main.getLastWordLength(str.toCharArray());
        System.out.println(result);
    }

    public int getLastWordLength(char[] str) {
        int l = 0, i = str.length - 1;
        boolean flag = true;
        while (i >= 0) {
            if (flag && str[i] == ' ') {
                i--;
                continue;
            }
            if (str[i] != ' ') {
                i--;
                flag = false;
                l++;
            } else {
                break;
            }
        }
        return l;
    }
}
