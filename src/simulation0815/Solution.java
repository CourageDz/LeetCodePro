package simulation0815;

public class Solution {
    public static void main(String[] args) {
        Integer x1 = Integer.valueOf(1);
        Integer x2 = Integer.valueOf(1);
        System.out.println(x1 == x2);

        Integer y1 = new Integer(1);
        Integer y2 = new Integer(1);
        System.out.println(y1 == y2);

        Integer z1 = Integer.parseInt("1");
        Integer z2 = Integer.parseInt("1");
        System.out.println(z1 == z2);
    }
}
