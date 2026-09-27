class Solution {
    public String reverseParentheses(String s) {
        Stack<Character>st=new Stack<>();
        for(char c:s.toCharArray()){
            String str="";
            if(c!=')'){
                st.add(c);
            }else if (c==')'){
                while(st.peek()!='('){
                    str+=st.pop();
                }
                st.pop();

                for(char nc:str.toCharArray()){
                    st.add(nc);
                }
            }
        }StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();

    }
}