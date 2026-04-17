class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result=new ArrayList<>();
        fun("",0,0,result,n);
        return result;
    }
    private void fun(String str,int open,int close,List<String>result,int max){
        if(str.length()==2*max){
            result.add(str);
        }
        if(open<max){
            fun(str+"(",open+1,close,result,max);
        }
        if(close<open){
            fun(str+")",open,close+1,result,max);
        }
    }
}