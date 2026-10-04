class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        boolean[][]dp=new boolean[n+1][n+1];
        dp[n][0]=true;;
        for(int i=n-1;i>=0;i--){
            for(int open=0;open<=n;open++){
                char c=s.charAt(i);
                if(c=='('){
                    if(open<n){
                        dp[i][open]=dp[i+1][open+1];
                    }
                }else if(c=='*'){
                    if(open<n){
                        dp[i][open]=dp[i+1][open+1] || dp[i+1][open] ;
                    }
                    if(open>0){
                         dp[i][open]=dp[i+1][open-1] || dp[i][open];
                    }
                }else{
                    if(open>0){
                        dp[i][open]=dp[i+1][open-1];
                    }
                }
            }
        }
        return dp[0][0];  
    } 
}