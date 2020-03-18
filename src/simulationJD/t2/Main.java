package simulationJD.t2;


import java.util.*;

public class Main {
    static class Person {
        int id;
        int count;

        public Person(int id, int count) {
            this.id = id;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[][] relation = new boolean[2 * n][2 * n];
            int[] count = new int[2 * n];
            for (int i = 0; i < m; i++) {
                int boy = sc.nextInt();
                int girl = sc.nextInt();
                if (boy > n) {
                    int temp = boy;
                    boy = girl;
                    girl = temp;
                }
                relation[boy - 1][girl - 1] = true;
                relation[girl - 1][boy - 1] = true;
                count[boy - 1]++;
                count[girl - 1]++;
            }
            ArrayList<Integer> list = getMinLeavePerson(n, relation, count);
            System.out.println(list.size());
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.printf(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }
    }

    private static ArrayList<Integer> getMinLeavePerson(int n, boolean[][] relation, int[] count) {
        Queue<Person> queue = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return a.id - b.id;
            } else {
                return b.count - a.count;
            }
        });
        HashMap<Integer, Person> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            if (count[i] != 0) {
                Person p = new Person(i + 1, count[i]);
                queue.add(p);
                map.put(i + 1, p);
            }
        }
        while (!queue.isEmpty()) {
            Person p = queue.poll();
            if (p.count > 0) {
                list.add(p.id);
                if (p.id > n) {
                    for (int i = 0; i < n; i++) {
                        if (relation[p.id - 1][i] == true) {
                            relation[i][p.id - 1] = false;
                            relation[p.id - 1][i] = false;
                            map.get(i + 1).count -= 1;
                        }
                    }
                } else {
                    for (int i = n; i < 2 * n; i++) {
                        if (relation[p.id - 1][i] == true) {
                            relation[i][p.id - 1] = false;
                            relation[p.id - 1][i] = false;
                            map.get(i + 1).count -= 1;
                        }
                    }
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
