package alg737;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static class Pair {
        String s1;
        String s2;

        public Pair(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, ArrayList<Pair> pairs) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pairs.size(); i++) {
            set.add(pairs.get(i).s1);
            set.add(pairs.get(i).s2);
        }
        return false;
    }
}
