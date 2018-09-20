package alg56;

public class Solution2 {
    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        long size=0;
        for(char c:S.toCharArray()){
            if(Character.isDigit(c)){
                size*=c-'0';
            }else
                size++;
        }
        long k=K;
        for (int i = n-1; i >=0 ; i--) {
            k=k%size;
            char c=S.charAt(i);
            if(k==0 && Character.isLetter(c))
                return Character.toString(c);
            else if(Character.isDigit(c))
                size/=c-'0';
            else
                size--;
        }
        throw null;
    }
    public static void main(String[] args) {
        Solution2 sol =new Solution2();
        String s="leet2code3";
        String result=sol.decodeAtIndex(s,10);
        System.out.println(result);
    }
}
