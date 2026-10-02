class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        fun("",0,0,n,ans);
        return ans;
    }
    private void fun(String curr,int open, int close,int n,List<String>ans){
        if(curr.length()==2*n){
            ans.add(curr);
        }
        if(open<n){
            fun(curr+"(",open+1,close,n,ans);
        }if(close<open){
            fun(curr+")",open,close+1,n,ans);
        }
    }
}