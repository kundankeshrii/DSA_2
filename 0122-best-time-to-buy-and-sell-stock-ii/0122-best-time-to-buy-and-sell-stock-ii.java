class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(0,1,prices,0,dp);
    }
    private int fun(int idx,int buy,int[]prices,int profit,int[][]dp){
        int n=prices.length;
        if(idx==n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            int take=-prices[idx]+fun(idx+1,0,prices,profit,dp);
            int notTake=0+fun(idx+1,1,prices,profit,dp);
            dp[idx][buy]=Math.max(take,notTake);
        }else{
            int sell=prices[idx]+fun(idx+1,1,prices,profit,dp);
            int notSell=0+fun(idx+1,0,prices,profit,dp);
            dp[idx][buy]=Math.max(sell,notSell);
        }
        return dp[idx][buy];
    }
}