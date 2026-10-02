class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        fun(0,sb,n,ans);
        return ans;
    }
    private void fun(int idx,StringBuilder sb,int n,List<String>ans){
        if(sb.length()==2*n){
            if(isValid(sb.toString())){
                ans.add(sb.toString());
                 
            }
            return;
        }
        sb.append("(");
        fun(idx+1,sb,n,ans);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        fun(idx+1,sb,n,ans);
        sb.deleteCharAt(sb.length()-1);
    }
    private boolean isValid(String s){
        int cnt=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt<0) return false;
        }
        return cnt==0;
    }
}