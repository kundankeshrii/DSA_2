class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][]dp=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
    return fun(0,1,2,prices,dp,0);
    }
    private int fun(int idx,int buy,int cap,int[]prices,int[][][]dp,int profit){
        int n=prices.length;
        if(idx==n) return 0;
        if(cap==0) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==1){
            int take=-prices[idx]+fun(idx+1,0,cap,prices,dp,profit);
            int notTake=0+fun(idx+1,1,cap,prices,dp,profit);
            profit=Math.max(notTake,take);
        }else{
            int sell=prices[idx]+fun(idx+1,1,cap-1,prices,dp,profit);
            int notSell=0+fun(idx+1,0,cap,prices,dp,profit);
            profit=Math.max(sell,notSell);
        }
        return dp[idx][buy][cap]=profit;
    }
}