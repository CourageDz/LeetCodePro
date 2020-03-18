package alg909;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int numBoard[] = new int[N * N + 1];
        int k = 1;
        for (int i = N - 1; i >= 0; i--) {
            if ((N - 1 - i) % 2 == 0) {
                for (int j = 0; j < N; j++) {
                    numBoard[k++] = board[i][j];
                }
            } else {
                for (int j = N - 1; j >= 0; j--) {
                    numBoard[k++] = board[i][j];
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean isVisit[] = new boolean[N * N + 1];
        isVisit[1] = true;
        queue.offer(1);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int now = queue.poll();
                for (int j = 1; j <= 6 && (now + j) <= N * N; j++) {
                    int next = now + j;
                    if (numBoard[next] != -1) {
                        next = numBoard[next];
                    }
                    if (!isVisit[next]) {
                        queue.offer(next);
                        isVisit[next] = true;
                    }
                    if (N * N == next)
                        return count;
                }

            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int n = 9;
        int boardNum[][] = new int[n][n];
        int k = 1;
        int dir[] = {1, -1};
        int j = 0;
        boolean dirFlag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (!dirFlag) {
                while (j < n) {
                    boardNum[i][j] = k++;
                    j += dir[0];
                }
                j--;
                dirFlag = true;
            } else {
                while (j >= 0) {
                    boardNum[i][j] = k++;
                    j += dir[1];
                }
                dirFlag = false;
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < n; l++) {
                System.out.print(boardNum[i][l] + " ");
            }
            System.out.println();
        }
    }
}
