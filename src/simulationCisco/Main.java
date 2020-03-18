package simulationCisco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer x = 123;
        Integer y = new Integer(123);
        System.out.println(x == y);
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            String result = getAlertNameOfUri(s.toCharArray());

            System.out.println(result);


        }
    }

    private static String getAlertNameOfUri(char[] arr) {
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        boolean sp = false;
        while (ind < n) {
            while (arr[ind] == '"') {
                ind++;
                continue;
            }
            if (arr[ind] == '%') {
                ind++;
                sp = true;
            }
            if (sp) {
                int low = ind + 2;
                int high = n - 1;
                boolean ifLast = false;
                while (high - 2 >= low) {
                    if (arr[high] == '2' && arr[high - 1] == '2' && arr[high - 2] == '%') {
                        ifLast = true;
                        high = high - 2;
                        break;
                    } else {
                        high--;
                    }
                }
                if (ifLast && high > low) {
                    for (int i = low; i < high; i++) {
                        sb.append(arr[i]);
                    }
                    return sb.toString();
                } else {
                    return "";
                }
            }
            if (arr[ind] == '<') {
                return sb.toString();
            } else {
                sb.append(arr[ind]);
                ind++;
            }
        }
        return "";
    }
}
