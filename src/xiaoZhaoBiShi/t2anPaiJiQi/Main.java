package xiaoZhaoBiShi.t2anPaiJiQi;

import java.util.*;

/***
 *题目描述：
 * 小Q的公司最近接到m个任务，第i个任务需要xi的时间去完成，难度等级为yi。
 * 小Q拥有n台机器，每台机器最长工作时间zi，机器等级wi。
 * 对于一个任务，它只能交由一台机器来完成，如果安排给它的机器的最长工作时间小于任务需要的时间，则不能完成，如果完成这个任务将获得200*xi+3*yi的收益。
 * 对于一台机器，它一天只能完成一个任务，如果它的机器等级小于安排给它的任务难度等级，则不能完成。
 * 小Q想在今天尽可能的去完成任务，即完成的任务数量最大。如果有多种安排方案，小Q还想找到收益最大的那个方案。
 *
 * 输入描述：
 * 输入包括N+M+1行，
 * 输入的第一行为两个正整数n和m（1<=n,m<=100000），表示机器的数量和任务的数量。
 * 接下来n行，每行两个整数xi和yi（0<xi<1000,0<=yi<=100），表示每台机器的最大工作时间和机器等级。
 * 接下来m行，每行两个整数zi和wi（0<zi<1000,0<=wi<=100），表示每个任务需要的完成时间和任务的难度等级。
 *
 * 输出描述：
 * 输出两个正整数，分别表示最大能完成的任务数量和获取的收益。
 *
 * 示例1：
 * 输入
 * 1 2
 * 100 3
 * 100 2
 * 100 1
 *
 * 输出
 * 1 20006
 * 二、解题思路：贪心求解。
 * 收益只与完成的任务x、y有关，且x、y越大，获得的收益越大，所以要优先完成x更大的任务，若x相等，则要优先完成y大的任务。
 * 为保证上述完成要求，我们可以将任务的x按从大到小排序，若x相同，根据y从大到小排序，排序完成后，再给任务分配机器。
 * 当有多台机器符合x条件，选择y满足条件的最小的wi。
 */

public class Main {
    public static void main(String[] args) {
        Main main=new Main();
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] machines=new int[n][2];
            int[][] tasks= new int[m][2];

            for (int i = 0; i <n ; i++) {
                machines[i][0]=sc.nextInt();
                machines[i][1]=sc.nextInt();
            }

            for (int i = 0; i <m ; i++) {
                tasks[i][0]=sc.nextInt();
                tasks[i][1]=sc.nextInt();
            }

            main.getMaxBenefit(machines,tasks);
        }
    }

    private void getMaxBenefit(int[][] machines, int[][] tasks) {
        int n=machines.length;
        int m=tasks.length;
        List<Node> taskList=new ArrayList<>();
        for (int i = 0; i <m ; i++) {
            taskList.add(new Node(tasks[i][0],tasks[i][1]));
        }
        Collections.sort(taskList);
        List<Node> machineList=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            machineList.add(new Node(machines[i][0],machines[i][1]));
        }
        Collections.sort(machineList);

        long sum=0;
        int count=0;
        int j=0;
        int[] mark=new int[100];
        for (int i = 0; i <m ; i++) {
            Node task=taskList.get(i);
            while (true){
                if(j<n){
                    Node machine=machineList.get(j);
                    if(machine.time>=task.time){
                        mark[machine.level]++;
                        j++;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }

            for (int k = task.level; k <100 ; k++) {
                if(mark[k]!=0){
                    mark[k]--;
                    sum+=getBenefit(task.time,task.level);
                    count++;
                    break;
                }
            }

        }
        System.out.println(count+" "+sum);
    }
    class Node implements Comparable<Node>{
        int time;
        int level;
        public Node(int time, int level) {
            this.time = time;
            this.level = level;
        }

        @Override
        public int compareTo(Node o) {
            if(this.time>o.time){
                return -1;
            }else if(this.time<o.time){
                return 1;
            }else {
                if(this.level>o.level){
                    return -1;
                }else if(this.level<o.level){
                    return 1;
                }else {
                    return 0;
                }
            }
        }
    }

    public static int getBenefit(int workT,int level){
        return 200*workT+3*level;
    }
}
