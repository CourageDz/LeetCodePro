package test;

import java.util.ArrayList;
import java.util.List;

public class TestString {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        TestString ts = new TestString();
        String a = "abc";
        String b = "abc";
        String c = a + b;
        String c1 = "abcabc";
        Integer i = 0;
        ts.modifyString(i);
        System.out.println(i);
        i++;
        System.out.println(c == c1);
        System.out.println(a == b);
        String a2 = new String("abc");
        a2 = a;
        System.out.println(b == a2);
        List<String> l1 = new ArrayList<>();
        l1.add("123");
        l1.add("1234");
        System.out.println(l1.size());
        System.out.println(l1.size());
        ts.modifyString(1, 2);
    }

    public final void modifyString(Integer a) {
        a++;
    }

    public void modifyString(Integer a, Integer b) {
        a++;
        b++;
        System.out.println(a);
    }

    public void modifyString2(List<String> s1) {
        List<String> l1 = new ArrayList<>();
        s1 = l1;
        s1.add("efg");
        System.out.println(s1.size());
    }
}
