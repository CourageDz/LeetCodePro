package alg871;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    //TL
    public int minRefuelStopsNotPassed(int target, int startFuel, int[][] stations) {
        if (startFuel >= target)
            return 0;
        else if (stations.length == 0 || startFuel < stations[0][0])
            return -1;
        else
            return dfs(target, startFuel, stations, 0, 0);
    }

    public int dfs(int target, int leftFuel, int[][] stations, int i, int count) {
        if (i >= stations.length && leftFuel >= target)
            return count;
        else if (i >= stations.length || leftFuel < stations[i][0])
            return -1;
        else if (leftFuel >= target)
            return count;
        else {
            int add = dfs(target, leftFuel + stations[i][1], stations, i + 1, count + 1);
            int noAdd = dfs(target, leftFuel, stations, i + 1, count);
            if (add == -1 && noAdd != -1)
                return noAdd;
            else if (add != -1 && noAdd == -1)
                return add;
            else if (add == -1 && noAdd == -1)
                return -1;
            else
                return add <= noAdd ? add : noAdd;
        }
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target)
            return 0;
        else if (stations.length == 0 || startFuel < stations[0][0])
            return -1;
        int fuel = startFuel;
        int count = 0;
        int locate = 0, i = 0;
        Queue<Integer> station = new PriorityQueue<>((a, b) -> b - a);
        while (fuel < target) {
            for (i = locate; i < stations.length; i++) {
                if (stations[i][0] <= fuel) {
                    station.offer(stations[i][1]);
                } else
                    break;
            }
            if (!station.isEmpty()) {
                fuel += station.poll();
                count++;
                locate = i;
            } else
                return -1;

        }
        return count;
    }

    public static void main(String[] args) {
        int targer = 1000;
        int startFule = 299;
//        int[][] stations={{10,60},{20,20},{30,20},{60,40}};
        int[][] stations = {
                {13, 21}, {26, 115}, {100, 47}, {225, 99}, {299, 141}, {444, 198}, {608, 190}, {636, 157}, {647, 255}, {841, 123}};
        Solution sol = new Solution();
        int result = sol.minRefuelStops(targer, startFule, stations);
        System.out.println(result);
    }
}
