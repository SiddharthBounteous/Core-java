package Algortihms;

import Generics.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        int n=s.length();
        if(n%2==1){
            return false;
        }
        Stack<Character>st=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch==')'){
                if(st.isEmpty() || st.peek()!='('){
                    return false;
                }
                else{
                    st.pop();
                }
            }
            else if(ch==']'){
                if(st.isEmpty() || st.peek()!='['){
                    return false;
                }
                else{
                    st.pop();
                }
            }
            else if(ch=='}'){
                if(st.isEmpty() || st.peek()!='{'){
                    return false;
                }
                else{
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }
        return st.isEmpty() ? true:false;
    }
}
