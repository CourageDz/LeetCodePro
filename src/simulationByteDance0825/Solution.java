package simulationByteDance0825;

public class Solution {
    public static void main(String[] args) {
        String s = "ab";
        String s2 = "cd";
        String s3 = s + s2;
        String s4 = "ab" + "cd";
        System.out.println(s3 == "abcd");
        System.out.println(s3 == s4);
        System.out.println("ab" + "cd" == s4);
    }
}
