package alg778;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    //使用List结果27 / 41 test cases passed. Time limit exceeded,使用PriorityQueue accecepted
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Queue<Integer[]> nodes = new PriorityQueue<>(n * n, (a, b) -> {
            return a[2] - b[2];
        });
//        Queue<Integer[]> nodes=new PriorityQueue<>(nodeComparator);
        boolean visit[][] = new boolean[n][n];
        int time = grid[0][0];
        addNode(nodes, 0, 0, grid[0][0]);
        while (!visit[n - 1][n - 1]) {
            while (true) {
                Integer[] node = nodes.peek();
                if (node[2] <= time && !visit[n - 1][n - 1]) {
                    nodes.poll();
                    int x = node[0];
                    int y = node[1];
                    visit[x][y] = true;
                    if (y + 1 < n && visit[x][y + 1] == false)
                        addNode(nodes, x, y + 1, grid[x][y + 1]);
                    if (x - 1 >= 0 && visit[x - 1][y] == false)
                        addNode(nodes, x - 1, y, grid[x - 1][y]);
                    if (x + 1 < n && visit[x + 1][y] == false)
                        addNode(nodes, x + 1, y, grid[x + 1][y]);
                    if (y - 1 >= 0 && visit[x][y - 1] == false)
                        addNode(nodes, x, y - 1, grid[x][y - 1]);
                } else
                    break;
            }
            time++;
        }
        return time - 1;
    }

    public void addNode(Queue<Integer[]> nodes, int i, int j, int value) {
        Integer[] node = new Integer[3];
        node[0] = i;
        node[1] = j;
        node[2] = value;
        nodes.add(node);
    }

    public Comparator<Integer[]> nodeComparator = new Comparator<Integer[]>() {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[2] - o2[2];
        }
    };

    public static void main(String[] args) {
        Solution sol = new Solution();
        int grid[][] = {
//                {0,1,2,3,4},
//                {24,23,22,21,5},
//                {12,13,14,15,16},
//                {11,17,18,19,20},
//                {10,9,8,7,6}
                {3, 2},
                {0, 1},
        };
        int result = sol.swimInWater(grid);
        System.out.println(result);
    }
}
