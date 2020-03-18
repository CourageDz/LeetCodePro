package simulationDiDi.t2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String[] items = sc.nextLine().trim().split(" ");
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(items[j]);
                }
            }

            addShuDu(arr);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.printf(arr[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    public static void addShuDu(int[][] arr) {
        boolean[] ifExist = new boolean[10];
        int count = 0;
        boolean ifFinal = true;
        while (true) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (arr[i][j] == 0) {
                        ifFinal = false;
                        Arrays.fill(ifExist, false);
                        count = 0;
                        for (int k = j - 1; k >= 0; k--) {
                            if (arr[i][k] != 0) {
                                ifExist[arr[i][k]] = true;
                                count++;
                            }
                        }

                        for (int k = j + 1; k < 9; k++) {
                            if (arr[i][k] != 0) {
                                ifExist[arr[i][k]] = true;
                                count++;
                            }
                        }

                        if (count == 8) {
                            for (int k = 1; k <= 9; k++) {
                                if (!ifExist[k]) {
                                    arr[i][j] = k;
                                }
                            }
                        } else {
                            Arrays.fill(ifExist, false);
                            count = 0;
                            for (int k = i - 1; k >= 0; k--) {
                                if (arr[k][j] != 0) {
                                    ifExist[arr[k][j]] = true;
                                    count++;
                                }
                            }

                            for (int k = i + 1; k < 9; k++) {
                                if (arr[k][j] != 0) {
                                    ifExist[arr[k][j]] = true;
                                    count++;
                                }
                            }
                            if (count == 8) {
                                for (int k = 1; k <= 9; k++) {
                                    if (!ifExist[k]) {
                                        arr[i][j] = k;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (ifFinal) {
                break;
            }
            ifFinal = true;
        }
    }
}
