class Solution {
    public int calculate(String s) {
        int result=0;
        int sign=1;
        int num=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }else if(ch=='+'){
                result+=sign*num;
                num=0;
                sign=1;
            }else if(ch=='-'){
                result+=sign*num;
                num=0;
                sign=-1;
            }else if(ch=='('){
                st.push(result);
                st.push(sign);
                //reset kar do 
                result=0;
                sign=1;
            }else if(ch==')'){
                result+=sign*num;
                num=0;
                //get previous results and sign
                int prevSign=st.pop();
                int prevResult=st.pop();

                result=prevResult+(prevSign*result);//2+(-1)*1=1
            }
        }
        if(num!=0){
            result+=sign*num;
        }
        return result;
    }
}