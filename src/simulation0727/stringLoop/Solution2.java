package simulation0727.stringLoop;

public class Solution2 {
    public static void main(String[] args) {
        String[] array = {"ABC", "GHI", "JKL", "CEWRTG", "ISFAJ", "LSFDAS", "SDFASA"};
        if (sortStrings(array)) {
//            for (int i = 0; i <array.length ; i++) {
//                System.out.println(array[i]);
//            }
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean sortStrings(String[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int[] num1 = new int[26];
        int[] num2 = new int[26];
        for (String s : array) {
            char start = s.charAt(0);
            char end = s.charAt(s.length() - 1);
            num1[start - 'A']++;
            num2[end - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }
        return true;
    }

}
