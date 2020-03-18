package simulationXiaoMi0905.ipStatistics;

import java.util.Scanner;

/***
 * IP地址统计
 * 测试用例
 * 2
 * 1
 * 192.168.12.2 192.168.12.3 1
 * 2
 * 10.100.108.34
 * 192.168.12.2
 * 3
 * 10.1.1.1 10.2.255.255 1
 * 223.199.12.2 224.200.19.12 2
 * 172.2.12.0 172.16.2.2 3
 * 3
 * 10.2.123.123
 * 10.2.255.255
 * 223.199.13.255
 */
public class Main3 {
    //ip区间类
    static class IpPeriod {
        String startIp;
        String endIp;
        //表示省份
        int proId;
        //记录该ip区间的访问次数
        int visitNums;
        //表示开始/结束ip对应的整数，因为int只可以存储2^31，因此可能存不下，这边使用了long来记录ip对应的整数
        long sIp;
        long eIp;

        public IpPeriod(String startIp, String endIp, int proId) {
            this.startIp = startIp;
            this.endIp = endIp;
            this.proId = proId;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int T = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < T; i++) {
                int n = sc.nextInt();
                sc.nextLine();

                IpPeriod[] ips = new IpPeriod[n];

                for (int j = 0; j < n; j++) {
                    String[] items = sc.nextLine().trim().split(" ");
                    ips[j] = new IpPeriod(items[0].trim(), items[1].trim(), Integer.parseInt(items[2]));
                }
                parseIp(ips);

                String ms = sc.nextLine().trim();
                int m = Integer.parseInt(ms);
                String[] visitIps = new String[m];
                for (int j = 0; j < m; j++) {
                    visitIps[j] = sc.nextLine().trim();
                }
                getVisitNumOfPros(visitIps, ips);
                for (int j = 0; j < n; j++) {
                    System.out.println(ips[j].proId + " " + ips[j].visitNums);
                }
            }
        }
    }

    //该函数用来转化ip区间数组中的ip字符串
    private static void parseIp(IpPeriod[] ips) {
        for (int i = 0; i < ips.length; i++) {
            String startIp = ips[i].startIp;
            long sip = getNumOfStringIp(startIp);
            ips[i].sIp = sip;

            String endIp = ips[i].endIp;
            long eip = getNumOfStringIp(endIp);
            ips[i].eIp = eip;
        }
    }

    //该函数用来转化ip从String到long
    private static long getNumOfStringIp(String startIp) {
        String[] items = startIp.split("\\.");
        if (items.length != 4) {
            return -1;
        }
        long res = 0;
        int a = Integer.parseInt(items[0]);
        int b = Integer.parseInt(items[1]);
        int c = Integer.parseInt(items[2]);
        int d = Integer.parseInt(items[3]);
        res += (a << 24);
        res += (b << 16);
        res += (c << 8);
        res += d;
        return res;
    }


    private static void getVisitNumOfPros(String[] visitIps, IpPeriod[] ips) {
        int n = visitIps.length;
        for (int i = 0; i < n; i++) {
            long ip = getNumOfStringIp(visitIps[i]);
            for (int j = 0; j < ips.length; j++) {
                if (ip >= ips[j].sIp && ip <= ips[j].eIp) {
                    ips[j].visitNums++;
                    break;
                }
            }
        }
    }

}
