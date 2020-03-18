package huaweiSimulation.t2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String MS = sc.nextLine().trim();
            int m = Integer.valueOf(MS);
            //第二行
            String labels = sc.nextLine().trim();
            String[] labelNums = labels.split(" ");
            //第三行
            String childs = sc.nextLine().trim();
            String[] childNums = childs.split(" ");
            //第四行
            String poudss = sc.nextLine().trim();
            String[] poudsNums = poudss.split(" ");
            //第五行
            String valueNum = sc.nextLine().trim();
            int val = Integer.valueOf(valueNum);
            //第六行
            String values = sc.nextLine().trim();
            String[] valueNums = values.split(" ");
            //第7行
            String keys = sc.nextLine().trim();
            int keyNums = Integer.valueOf(keys);
            //第8行
            String ques = sc.nextLine().trim();
            String[] quess = ques.split(" ");
            int result = getResultOfQues(m, labelNums, childNums, poudsNums, valueNums, quess);
            System.out.println(result);
        }
    }

    private static int getResultOfQues(int m, String[] labelNums, String[] childNums, String[] poudsNums, String[] valueNums, String[] quess) {
        int lastIndex = m - 1;
        int index = m - 1;
        int count = 1;
        for (int i = 0; i < quess.length; i++) {
            count = 1;
            for (int j = index; j >= 0; j--) {
                if (labelNums[j].equals(quess[i])) {
                    lastIndex = index;
                    index = i;
                    break;
                } else {
                    count++;
                }
            }
            for (int j = index - 1; j >= 0; j--) {
                if (labelNums[j].equals("1")) {
                    index = j;
                    break;
                }
            }
            for (int j = index - 1; j >= 0; j--) {
                if (poudsNums[j].equals("1") && childNums[j].equals("1")) {
                    count--;
                    if (count == 0) {
                        index = j;
                        break;
                    }
                }
            }
        }

        return 0;

    }
}
