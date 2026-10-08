class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        Stack<Character>st=new Stack<>();
        int open=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
                st.push(ch);
                if(open>1){
                ans+='(';
                }
            }else{
                open--;
                if(st.peek()=='(' && open>0){
                ans+=')';
                }
                st.pop();
            }
        }
    return ans;
    }
}