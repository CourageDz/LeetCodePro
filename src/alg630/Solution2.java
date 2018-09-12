package alg630;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {
    class Course {
        int duration;
        int endDate;

        Course(int d, int end) {
            duration = d;
            endDate = end;
        }
    }
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Course[] courseArray = new Course[n];

        for (int i = 0; i < n; i++) {
            courseArray[i] = new Course(courses[i][0], courses[i][1]);
        }
        Arrays.sort(courseArray, (first, second) -> {
            if (first.endDate == second.endDate)
                return first.duration - second.duration;
            else
                return first.endDate - second.endDate;
        });
        PriorityQueue<Course> coursesQueue=new PriorityQueue<>((a,b)->b.duration-a.duration);
        int time=0;
        for (int i = 0; i <n ; i++) {
            if(time+courseArray[i].duration<=courseArray[i].endDate){
                coursesQueue.offer(courseArray[i]);
                time+=courseArray[i].duration;
            }else if(!coursesQueue.isEmpty()&&courseArray[i].duration<coursesQueue.peek().duration ){
                Course maxCourse=coursesQueue.poll();
                time+=courseArray[i].duration-maxCourse.duration;
                coursesQueue.offer(courseArray[i]);
            }
        }
        return coursesQueue.size();
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int courses[][] = {{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
        int res = sol.scheduleCourse(courses);
        System.out.println(res);
    }
}
