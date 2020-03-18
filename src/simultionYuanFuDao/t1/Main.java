package simultionYuanFuDao.t1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            ArrayList<Integer> list = getDeleteRepeatDyM(array, m);
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.printf(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }
    }

    private static ArrayList<Integer> getDeleteRepeatDyM(int[] array, int m) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], hashMap.getOrDefault(array[i], 0) + 1);
        }
        for (int i = 0; i < array.length; i++) {
            if (hashMap.get(array[i]) < m) {
                list.add(array[i]);
            }
        }
        return list;
    }
}
