package byteDance.qiuZhao.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int[] array=new int[n];
            for (int i = 0; i <n ; i++) {
                array[i]=sc.nextInt();
            }

            System.out.println(getMinTanGuo(n,array));
        }
    }

    private static long getMinTanGuo(int n, int[] array) {
        Arrays.sort(array);
        long count=1;
        int num=1;
        for(int i=1;i<n;i++){
            if(array[i]==array[i-1]){
                count+=num;
            }else {
                num++;
                count+=num;
            }
        }
        return count;
    }
}
