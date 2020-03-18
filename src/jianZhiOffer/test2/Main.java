package jianZhiOffer.test2;

public class Main {
    public String replaceSpace(StringBuffer str) {
        int n = str.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        StringBuffer sb = new StringBuffer("  ");
        System.out.println(main.replaceSpace(sb));
    }
}
