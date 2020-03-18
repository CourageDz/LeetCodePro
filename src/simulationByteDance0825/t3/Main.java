package simulationByteDance0825.t3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[][] array = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
            getResultOfMove(n, array);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.printf(array[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void getResultOfMove(int n, int[][] array) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < 4; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    if (j + 1 < 4 && array[j][i] != 0 && array[j][i] == array[j + 1][i]) {
                        list.add(2 * array[j][i]);
                        array[j + 1][i] = 0;
                    } else if (array[j][i] != 0) {
                        list.add(array[j][i]);
                    }
                }
                int temp = list.size();
                if (temp < 4) {
                    for (int j = 0; j < 4 - temp; j++) {
                        list.add(0);
                    }
                }
                lists.add(list);
            }
            int count = 0;
            for (ArrayList<Integer> list : lists) {
                for (int j = 0; j < 4; j++) {
                    array[j][count] = list.get(j);
                }
                count++;
            }
        } else if (n == 2) {
            for (int i = 0; i < 4; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 3; j >= 0; j--) {
                    if (j - 1 >= 0 && array[j][i] != 0 && array[j][i] == array[j - 1][i]) {
                        list.add(2 * array[j][i]);
                        array[j - 1][i] = 0;
                    } else if (array[j][i] != 0) {
                        list.add(array[j][i]);
                    }
                }
                int temp = list.size();
                if (temp < 4) {
                    for (int j = 0; j < 4 - temp; j++) {
                        list.add(0);
                    }
                }
                lists.add(list);
            }
            int count = 0;
            int numcount = 0;
            for (ArrayList<Integer> list : lists) {
                numcount = 0;
                for (int j = 3; j >= 0; j--) {
                    array[j][count] = list.get(numcount++);
                }
                count++;
            }
        } else if (n == 3) {
            for (int i = 0; i < 4; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    if (j + 1 < 4 && array[i][j] != 0 && array[i][j] == array[i][j + 1]) {
                        list.add(2 * array[i][j]);
                        array[i][j + 1] = 0;
                    } else if (array[i][j] != 0) {
                        list.add(array[i][j]);
                    }
                }
                int temp = list.size();
                if (temp < 4) {
                    for (int j = 0; j < 4 - temp; j++) {
                        list.add(0);
                    }
                }
                lists.add(list);
            }
            int count = 0;
            int numCount = 0;
            for (ArrayList<Integer> list : lists) {
                numCount = 0;
                for (int j = 0; j < 4; j++) {
                    array[count][j] = list.get(numCount++);
                }
                count++;
            }
        } else if (n == 4) {
            for (int i = 0; i < 4; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 3; j >= 0; j--) {
                    if (j - 1 >= 0 && array[i][j] != 0 && array[i][j] == array[i][j - 1]) {
                        list.add(2 * array[i][j]);
                        array[i][j - 1] = 0;
                    } else if (array[i][j] != 0) {
                        list.add(array[i][j]);
                    }
                }
                int temp = list.size();
                if (temp < 4) {
                    for (int j = 0; j < 4 - temp; j++) {
                        list.add(0);
                    }
                }
                lists.add(list);
            }
            int count = 0;
            int numcount = 0;
            for (ArrayList<Integer> list : lists) {
                numcount = 0;
                for (int j = 3; j >= 0; j--) {
                    array[count][j] = list.get(numcount++);
                }
                count++;
            }
        }
    }
}
