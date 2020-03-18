package alg636;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];
        String lastToken = "";
        int lastValue = 0;
        Deque<Integer> indexes = new ArrayDeque<Integer>();
        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] items = log.split(":");
            int index = Integer.parseInt(items[0]);
            String token = items[1];
            int value = Integer.parseInt(items[2]);
            if (i == 0) {
                lastToken = token;
                lastValue = value;
                indexes.addLast(index);
                continue;
            }
            if (items[1].equals("start")) {
                if (!indexes.isEmpty()) {
                    int frontIndex = indexes.getLast();
                    if (lastToken.equals("end")) {
                        times[frontIndex] += value - lastValue - 1;
                    } else {
                        times[frontIndex] += value - lastValue;
                    }
                }
                indexes.offerLast(index);
            } else {
                int frontIndex = indexes.pollLast();
                if (lastToken.equals("end")) {
                    times[index] += value - lastValue;
                } else {
                    times[frontIndex] += value - lastValue + 1;
                }
            }
            lastToken = token;
            lastValue = value;
        }
        return times;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] logss = {"0:start:0", "0:end:0", "1:start:1", "1:end:1", "2:start:2", "2:end:2", "2:start:3", "2:end:3"};
        List<String> logs = Arrays.asList(logss);
        Solution sol = new Solution();
        int[] result = sol.exclusiveTime(n, logs);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
