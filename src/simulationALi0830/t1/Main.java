package simulationALi0830.t1;


import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
/**bgbbbgbggbgbg   3  **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String getIndexAndLongest(String users, int k) {
        if (users == null || users.length() == 0) {
            return "";
        }
        char[] stus = users.toCharArray();
        int n = stus.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            char c = stus[i];
            if (i >= 1 && c == stus[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        boolean ifGirl = true;
        int last = 0;
        int maxGirl = Integer.MIN_VALUE, maxBoyId = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (stus[i] == 'g' && last == 0) {
                last = dp[i];
            } else if (stus[i] == 'b') {
                int count = 0;
                if (i - 1 >= 0 && stus[i - 1] == 'g') {
                    count = last + stus[i - 1];
                } else {
                    count = last;
                }
                last = 0;
                if (count >= maxGirl) {
                    maxGirl = count;
                    maxBoyId = i;
                }
            } else {
                continue;
            }
        }
        int l = 0, r = 0, c = 0, boys = 0;
        for (int i = r; i < n; i++) {
            if (stus[i] == 'g') {
                c++;
                if (c == k + 1) {
                    break;
                }
            } else {
                boys++;
            }
        }
        for (int i = r; i < n; i++) {
            if (stus[i] == 'g') {
                for (int j = l; j < r; j++) {
                    if (stus[j] == 'b') {
                        boys--;
                    } else {
                        l = j;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {

        }
        return "";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        int num = in.nextInt();

        res = getIndexAndLongest(_users, num);
        System.out.println(res);
    }
}
