package alg554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        int m = 0;
        for (Integer x : wall.get(0)) {
            m += x;
        }
        int ln = wall.get(0).size();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int station = 0;
            for (Integer x : wall.get(i)) {
                station += x;
                count.put(station, count.getOrDefault(station, 0) + 1);
            }
        }
        count.remove(m);
        int min = n;
        for (Integer num : count.values()) {
            min = Math.min(min, n - num);
        }
        return min;
    }
}
