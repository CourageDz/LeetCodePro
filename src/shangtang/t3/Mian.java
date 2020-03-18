package shangtang.t3;

public class Mian {
    public static void main(String[] args) {
        String pattern = "a/b/#";
        String s0 = "a/b/c/d";
        boolean result = judgeRelation(pattern.split("/"), s0.split("/"));
        System.out.println(result);
    }

    public static boolean judgeRelation(String[] pattern, String[] topic) {
        int n1 = pattern.length;
        int n2 = topic.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (pattern[i].equals(topic[j]) || pattern[i] == "+") {
                i++;
                j++;
            } else if (pattern[i].equals("#") && i != n1 - 1) {
                return false;
            } else if (pattern[i].equals("#") && i == n1 - 1) {
                return true;
            } else {
                return false;
            }
        }
        if (j == n2 - 1) {
            return true;
        } else {
            return false;
        }
    }
}
