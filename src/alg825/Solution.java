package alg825;

public class Solution {
    public int numFriendRequests2(int[] ages) {
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                boolean result1 = isRequestFri(ages[i], ages[j]);
                boolean result2 = isRequestFri(ages[j], ages[i]);
                if (result1 && result2)
                    count += 2;
                else if (result1 || result2)
                    count += 1;
            }
        }
        return count;
    }

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;
    }

    public boolean isRequestFri(int a, int b) {
        if (b <= (0.5 * a + 7) || b > a || (b > 100 && a < 100))
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ages = {73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110};
        int reuslt = sol.numFriendRequests(ages);
        System.out.println(reuslt);
    }
}
