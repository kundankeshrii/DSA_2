class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int[][]dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,0,s,false,dp);
        
    }
    private boolean fun(int i,int open,String s,boolean isValid,int[][]dp){
        if(open<0) return true;
        if(i==s.length()){
            return open==0;
        }
        if(dp[i][open]!=-1) return dp[i][open]==1;
        char c=s.charAt(i);
        if(c=='('){
            isValid=fun(i+1,open+1,s,isValid,dp);
        }else if(c=='*'){
            isValid=fun(i+1,open+1,s,isValid,dp) || fun(i+1,open,s,isValid,dp);
            if(open>0){
                isValid=fun(i+1,open-1,s,isValid,dp) || isValid;
            }  
        }else{
            if(open>0){
                isValid=fun(i+1,open-1,s,isValid,dp);
            }
        }
        dp[i][open]=isValid ?1:0;
        return isValid;
    }
    
}