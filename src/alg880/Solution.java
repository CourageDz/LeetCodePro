package alg880;

public class Solution {
    //运行时间超时
    public String decodeAtIndex(String S, int K) {
        int n=S.length();
        StringBuffer sb =new StringBuffer();
        int temp=0;
        for(char c:S.toCharArray()){
            if(!(c>='0'&&c<='9')){
                if(temp!=0){
                    String s=sb.toString();
                    for (int i = 0; i < temp-1; i++) {
                        sb.append(s);
                    }
                    temp=0;
                }
                sb.append(c);
            }else {
                if(temp!=0){
                    int num=c-'0';
                    temp*=num;
                }else {
                    temp=c-'0';
                }
            }
        }
        if(temp!=0){
            String s=sb.toString();
            for (int i = 0; i < temp-1; i++) {
                sb.append(s);
            }
        }
        String result=sb.toString();
        return result.substring(K-1,K);
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        String s="a2345678999999999999999";
        String result=sol.decodeAtIndex(s,10);
        System.out.println(result);
    }
}
