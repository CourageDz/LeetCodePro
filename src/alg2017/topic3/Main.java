package alg2017.topic3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (str != null) {
            String[] arr = str.trim().split(" ");
            for (String s : arr) {
                set.add(s);
            }
            str = br.readLine();
        }
        System.out.println(set.size());

    }
}
