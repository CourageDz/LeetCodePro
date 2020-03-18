package alg207;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course courses[] = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Course thisCourse = courses[prerequisites[i][0]];
            thisCourse.pre = courses[prerequisites[i][1]];
        }
        boolean isFinish = false;
        for (int i = 0; i < prerequisites.length; i++) {
            isFinish |= isCircle(courses[prerequisites[i][0]], courses[prerequisites[i][1]]);
            if (isFinish)
                break;
        }
        if (!isFinish)
            return true;
        else
            return false;

    }

    public boolean isCircle(Course a, Course b) {
        boolean iscircle = false;
        if (b.pre == null) {
            return false;
        }
        if (a.number == b.pre.number) {
            iscircle = true;
        } else {
            iscircle |= isCircle(a, b.pre);
        }
        return iscircle;
    }

    class Course {
        Course pre;
        int number;

        Course(int n) {
            number = n;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = 3;
        int[][] preRequisites = {
                {1, 0},
                {2, 0},
                {0, 2},
        };
        boolean result = sol.canFinish(3, preRequisites);
        System.out.println(result);
    }

}
