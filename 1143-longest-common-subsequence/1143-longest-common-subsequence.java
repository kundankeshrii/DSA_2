class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(m-1,n-1,text1,text2,dp);
    }
    private int fun(int idx1,int idx2,String s1,String s2,int[][]dp){
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return dp[idx1][idx2]=1+fun(idx1-1,idx2-1,s1,s2,dp);
        }
        return dp[idx1][idx2]=0+Math.max(fun(idx1-1,idx2,s1,s2,dp) ,fun(idx1,idx2-1,s1,s2,dp));
    }
}