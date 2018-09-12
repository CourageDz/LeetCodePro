package alg1;

public class sumSolution {
    public int[] twoSum(int[] nums, int target) {
        int []a =new int[2];
        for(int i=2;i<=nums.length;i++)
            for(int j=0;j<nums.length-i+1;++j){
                int k=i+j-1;
                if(nums[j]+nums[k]==target){
                    a[0]=j;
                    a[1]=k;
                    return a;
                }
            }
        return null;
    }

    public static void main(String[] args) {
        sumSolution sum=new sumSolution();
        int[] nums ={2,13,11,7};
        int target =9;
        int []a=sum.twoSum(nums,target);
        System.out.printf("[");
        for (int i = 0; i <a.length-1 ; i++) {
            System.out.printf(a[i]+",");
        }
        System.out.printf(a[a.length-1]+"]");
    }
}
