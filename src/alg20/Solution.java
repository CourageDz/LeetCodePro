package alg20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack st =new Stack();
        int n=s.length();
        for(char c:s.toCharArray()){
                if(st.empty())
                    st.push(c);
                else if(((char)st.peek()=='(' && c==')') || ((char)st.peek()=='{' && c=='}') || ((char)st.peek()=='[' && c==']'))
                    st.pop();
                else
                    st.push(c);
        }
        if(st.empty()){
            return true;
        }else
            return false;
    }
}
