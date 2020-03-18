package heapSort;

public class Dijistra {

    //计算指定起点到其他顶点的最短路径
    public void dijstra(int[][] matrix, int vo, boolean[] ifVisit, int[] route, int[] distance) {
        int n = distance.length;
        for (int i = 0; i < n; i++) {
            ifVisit[i] = false;
            distance[i] = 0;
        }
        ifVisit[vo] = true;
        for (int i = 0; i < n; i++) {
            if (matrix[vo][i] != Integer.MAX_VALUE) {
                distance[i] = matrix[vo][i];
            }
        }
        distance[vo] = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (!ifVisit[j] && distance[j] > min) {
                    min = distance[j];
                    k = j;
                }
            }
            ifVisit[k] = true;
            for (int j = 0; j < n; j++) {
                int temp = distance[k] + matrix[k][j];
                if (!ifVisit[j] && temp < distance[j]) {
                    distance[j] = temp;
                    route[j] = k;
                }
            }
        }
    }
}
