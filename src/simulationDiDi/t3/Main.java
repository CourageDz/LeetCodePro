package simulationDiDi.t3;

public class Main {
    public static void main(String[] args) {

    }

    public static int getMinCounts(char[] arr, int m) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int k = i;
            while (k < n) {
                if (k > 0) {
                    count += k / m;
                    if (k % m != 0) {
                        count += 1;
                    }
                }
                while (arr[k] == arr[i])
                    for (int j = k + 1; j < n; j++) {
                        if (arr[j] == arr[i]) {

                        }
                    }

            }
        }
        return 0;
    }
}
