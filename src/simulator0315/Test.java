package simulator0315;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        System.out.println(val());
    }

    public static int val() {
        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }

    //    List<String> list=new ArrayList<>();
    Set<String> set = new HashSet<>();
}

