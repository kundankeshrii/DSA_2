class Solution {
    public boolean isMatch(String s, String p) {
        String temp=s;
        s=p;
        p=temp;

        int n=s.length();
        int m=p.length();
        int[][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,m-1,s,p,dp);
    }
    private boolean fun(int i,int j,String s,String p,int[][]dp){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int k=0;k<=i;k++){
                if(s.charAt(k)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;
        boolean result;
        if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='?'){
            result=fun(i-1,j-1,s,p,dp);
        }else if(s.charAt(i)=='*'){
            result=fun(i-1,j,s,p,dp) || fun(i,j-1,s,p,dp);
        }else{
            result=false;
        }
        dp[i][j]=result?1:0;
        return result;
    }
}