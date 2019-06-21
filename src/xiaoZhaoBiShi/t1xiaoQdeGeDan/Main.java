package xiaoZhaoBiShi.t1xiaoQdeGeDan;

import java.util.*;

/***
 * 【题目描述】小 Q有 X首长度为A的不同歌和 Y首长度为 B的不同歌，现在小 Q想用这些歌组成一个总长度正好为 K的歌单， 每首最多只能在中出现一次不考虑内曲先后顺序情况下,请问有多少种组成歌单的方法。
 * 输入描述 ：
 * 每个输入包含一测试用例。
 * 每个测试用例的第一行包含整数，表示歌单总长度 K(1<=K<=1000)
 * 接下来的一行包含四个正整数，分别表示歌第种长度 A(A<=10)和数量 X(X<=100)以及歌的第二种长度 以及歌的第二种长度 B(B<=10)和数量 Y(Y<=100)。保证A不等于 B。
 * 输出描述 ：
 * 输出一个整数 ,表示组成歌单的方法取模。因为答案可能会很大 ,输出对 1000000007取模的结果。 取模的结果。
 * 输入示例 ：
 * 5
 * 2 3 3 3
 * 输出示例 输出示例 ：
 * 9
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int k=sc.nextInt();
            int a=sc.nextInt();
            int aNum=sc.nextInt();
            int b=sc.nextInt();
            int bNum=sc.nextInt();
            System.out.println(getGeDan(k,a,aNum,b,bNum));
        }
    }

    private static int getGeDan(int k, int a, int x, int b, int y) {
        int[][] c=new int[101][101];
        int mod=1000000007;
        int ans=0;
        c[0][0]=1;
        for(int i = 1;i <= 100;i++)
        {
            c[i][0] = 1;
            for(int j = 1;j <= 100;j++)
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
        }
//        for (int i = 0; i <101 ; i++) {
//            for (int j = 0; j <101 ; j++) {
//                System.out.printf(c[i][j]+" ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i <= x; i++) {
            if (i * a <= k && (k - a * i) % b == 0 && (k - a * i) / b <= y)
                ans = (ans + (c[x][i] * c[y][(k - a * i) / b]) % mod) % mod;
        }

        return ans;
    }


}
