package dajiang0906.t3;

import java.util.Scanner;

public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            count = 0;
            int money = sc.nextInt();
            int kinds = sc.nextInt();
            int[] foods = new int[kinds + 1];
            for (int i = 1; i <= kinds; i++) {
                foods[i] = sc.nextInt();
            }
            int likeNum = sc.nextInt();
            int[] like = new int[likeNum + 1];
            for (int i = 1; i <= likeNum; i++) {
                like[i] = sc.nextInt();
            }
            int result = getMaxFangAn(foods, like, money);
            System.out.println(result);
        }
    }

    private static int getMaxFangAn(int[] foods, int[] like, int money) {
        coumputeKFood(foods, like, 1, money);
//        if(like.length!=foods.length){
//            int[] nmFoods=new int[foods.length-like.length];
//            boolean[] flag=new boolean[foods.length];
//            for(int i=1;i<=like.length;i++){
//                flag[like[i]]=true;
//            }
//            int k=0;
//            for (int i = 1; i <=foods.length ; i++) {
//                if(!flag[i]){
//                    nmFoods[k++]=foods[i];
//                }
//            }
//            computeNormalFood(nmFoods,foods.length-like.length,money);
//        }

        return count;
    }

//    private static void computeNormalFood(int[] nmFoods, int k, int money) {
//        dfs2(nmFoods,0,k,0,money);
//    }

//    private static void dfs2(int[] nmFoods, int i, int k, int cc, int money) {
//        if(cc==money){
//            count++;
//            if(count>=10000007){
//                count%=10000007;
//            }
//            return;
//        }
//        if(cc>money||i>=k){
//            return;
//        }
//        int maxNum=(money-cc)/nmFoods[i];
//        for (int j = maxNum; j >=0; j--) {
//            dfs2(nmFoods,i+1,k,cc-nmFoods[i]*j,money);
//        }
//    }

    private static void coumputeKFood(int[] foods, int[] like, int i, int cMoney) {
        int maxNum = cMoney / foods[like[i]];
        for (int j = maxNum; j > 0; j--) {
            dfs(foods, like, j, i + 1, cMoney - j * foods[like[i]]);
        }
    }

    private static void dfs(int[] foods, int[] like, int lastFoodNum, int i, int cMoney) {
        if (cMoney == 0) {
            count++;
            if (count >= 10000007) {
                count %= 10000007;
            }
        }
        if (i > like.length - 1 || cMoney < 0) {
            return;
        }

        int maxNum = cMoney / foods[like[i]];
        if (lastFoodNum != 0) {
            if (maxNum >= lastFoodNum) {
                maxNum = lastFoodNum - 1;
            }
        } else {
            maxNum = 0;
        }
        for (int j = maxNum; j > 0; j--) {
            dfs(foods, like, j, i + 1, cMoney - j * foods[like[i]]);
        }
    }
}
