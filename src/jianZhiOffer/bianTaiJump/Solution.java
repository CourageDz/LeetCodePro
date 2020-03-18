package jianZhiOffer.bianTaiJump;

public class Solution {
    public int JumpFloorII(int target) {
        int[] array = new int[target + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= target; i++) {
            array[i] = 2 * array[i - 1];
        }
        return array[target];
    }

    public static void main(String[] args) {
        String s2 = "hello";
        String s0 = new String("hello");
        String s1 = new String("hello");
        String s3 = "hel" + "llo";
        String s4 = "hello";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
        System.out.println(s4 == s2);
        System.out.println(s0.equals(s1));

    }
}
