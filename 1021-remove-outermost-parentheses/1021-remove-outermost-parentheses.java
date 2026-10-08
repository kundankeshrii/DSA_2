class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        int open=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
                if(open>1){
                ans+='(';
                }
            }else{
                open--;
                if(open>0){
                ans+=')';
                }
            }
        }
    return ans;
    }
}