class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();
        for(String s:tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int pop2=st.pop();
                int pop1=st.pop();
                if(s.equals("+"))  st.push(pop1+pop2);
                if(s.equals("-"))  st.push(pop1-pop2);
                if(s.equals("*"))  st.push(pop1*pop2);
                if(s.equals("/") && pop2!=0)  st.push(pop1/pop2);
            }else{
                st.push(Integer.parseInt(s));
            }
                
            }
        return st.peek();
    }
}