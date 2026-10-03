class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][]dp=new int[n+1][2][3];
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        int take=-prices[idx]+dp[idx+1][0][cap];
                        int notTake=dp[idx+1][1][cap];
                        dp[idx][buy][cap]=Math.max(notTake,take);
                    }else{
                        int sell=prices[idx]+dp[idx+1][1][cap-1];
                        int notSell=dp[idx+1][0][cap];
                        dp[idx][buy][cap]=Math.max(sell,notSell);
                    }
                    
                }
            }
        }
        return dp[0][1][2];
    }
}