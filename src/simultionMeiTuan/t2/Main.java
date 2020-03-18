package simultionMeiTuan.t2;

/***
 * 已知一种新的火星文的单词由英文字母组成，但是此火星文中的字母先后顺序未知。给出一组非空的火星文单词，且此组单词已经按火星文字典序进行好了排序，请推断出此火星文中的字母先后顺序。
 *
 * 输入
 * 一行文本，为一组按火星文字典序排序好的单词(单词两端无引号)，单词之间通过空格隔开
 *
 * 输出
 * 按火星文字母顺序输出出现过的字母，字母之间无其他字符，如果无法确定顺序或者无合理的字母排序可能，请输出"invalid" (无需引号)
 *
 *
 * 样例输入
 * wrt wrf er ett rftt
 * 样例输出
 * wertf
 *
 * 提示
 * 输入样例2
 * z x
 * 输出样例2
 * zx
 *
 * 输入样例3
 * z x z
 * 输出样例3
 * invalid
 */

import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    static class Node {
        char c;
        int index;

        public Node(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            String[] array = s.split(" ");
            String result = getSerialOfArray(array);
            System.out.println(result);
        }
    }

    private static String getSerialOfArray(String[] array) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Node> list = new LinkedList();
        char[] subArray = array[0].toCharArray();
        int index = 0;
        for (int i = 0; i < subArray.length; i++) {
            list.addLast(new Node(subArray[i], index++));
        }
        for (int i = 1; i < array.length; i++) {
            subArray = array[i].toCharArray();
            boolean[] ifExist = new boolean[subArray.length];
            int[] index1 = new int[subArray.length];
            for (int j = 0; j < subArray.length; j++) {
                if (list.contains(subArray[j])) {
                    ifExist[j] = true;
                    index1[j] = j;
                }
            }

        }
        return "wertf";
    }
}
