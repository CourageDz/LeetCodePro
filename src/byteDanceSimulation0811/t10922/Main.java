package byteDanceSimulation0811.t10922;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String s1 = "101";
        String s2 = "1000";
        String res = getAdd(s1.toCharArray(), s2.toCharArray());
        System.out.println(res);
    }

    public static String getAdd(char[] arr1, char[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int ind1 = n1 - 1;
        int ind2 = n2 - 1;
        StringBuffer sb = new StringBuffer();
        char c = '0';
        while (ind1 >= 0 && ind2 >= 0) {
            if (arr1[ind1] == '1' && arr2[ind2] == '1') {
                if (c == '1') {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                c = '1';
            } else if (arr1[ind1] == '1' || arr2[ind2] == '1') {
                if (c == '1') {
                    sb.append(0);
                    c = '1';
                } else {
                    sb.append(1);
                    c = '0';
                }
            } else {
                sb.append(0);
                c = 0;
            }
            ind1--;
            ind2--;
        }
        if (n1 == n2) {
            if (c == '1') {
                sb.append(1);
            }
        } else {
            while (ind1 >= 0) {
                if (c == 1) {
                    if (arr1[ind1] == '1') {
                        sb.append(0);
                        c = 1;
                    } else {
                        sb.append(1);
                        c = 0;
                    }
                } else {
                    sb.append(arr1[ind1]);
                }
                ind1--;
            }

            while (ind2 >= 0) {
                if (c == 1) {
                    if (arr2[ind2] == '1') {
                        sb.append(0);
                        c = 1;
                    } else {
                        sb.append(1);
                        c = 0;
                    }
                } else {
                    sb.append(arr2[ind2]);
                }
                ind2--;
            }
        }
        String s = sb.reverse().toString();
        return s;
    }
}
