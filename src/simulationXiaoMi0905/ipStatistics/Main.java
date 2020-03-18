package simulationXiaoMi0905.ipStatistics;

import java.util.*;

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
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int T = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < T; i++) {
                int n = sc.nextInt();
                sc.nextLine();
                //proMap记录首地址ip到省份id
                HashMap<Long, Integer> proMap = new HashMap<>();
                //visitMap记录省份id到访问次数
                TreeMap<Integer, Integer> visitMap = new TreeMap<>();
                //ipList表示ip的区间段
                ArrayList<Long> ipList = new ArrayList<>();
                ipList.add(0L);
                ipList.add(((long) Math.pow(2, 32) - 1));

                for (int j = 0; j < n; j++) {
                    String[] items = sc.nextLine().trim().split(" ");
                    int proId = Integer.parseInt(items[2]);
                    long startIp = getNumOfStringIp(items[0].trim());
                    long endIp = getNumOfStringIp(items[1].trim());
                    ipList.add(startIp);
                    ipList.add(endIp);
                    proMap.put(startIp, proId);
                    visitMap.put(proId, 0);
                }
                Collections.sort(ipList);

                String ms = sc.nextLine().trim();
                int m = Integer.parseInt(ms);
                String[] visitIps = new String[m];
                for (int j = 0; j < m; j++) {
                    visitIps[j] = sc.nextLine().trim();
                }
                getVisitNumOfPros(visitIps, ipList, proMap, visitMap);
                for (Map.Entry entry : visitMap.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
        }
    }

    //对每个ip进行二分查找，来确定它所在的区间段，如果区间段的首地址存在于proMap中，则对其访问次数加1，否则跳过
    private static void getVisitNumOfPros(String[] visitIps, ArrayList<Long> ipList, HashMap<Long, Integer> proMap, TreeMap<Integer, Integer> visitMap) {
        for (int i = 0; i < visitIps.length; i++) {
            long ip = getNumOfStringIp(visitIps[i]);
            int low = 0, high = ipList.size() - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (high - low == 1) {
                    long startIp = ipList.get(low);
                    if (proMap.containsKey(startIp)) {
                        int proId = proMap.get(startIp);
                        visitMap.put(proId, visitMap.get(proId) + 1);
                        break;
                    } else {
                        break;
                    }
                } else if (ipList.get(mid) >= ip) {
                    high = mid;
                } else if (ipList.get(mid) < ip) {
                    low = mid;
                }
            }
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

}
