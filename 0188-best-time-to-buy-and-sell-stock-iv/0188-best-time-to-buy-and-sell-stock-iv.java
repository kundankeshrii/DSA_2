class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n+1][2*k+1];
        for(int idx=n-1;idx>=0;idx--){
            for(int txn=2*k-1;txn>=0;txn--){
                if(txn%2==0){
                    int buy=-prices[idx]+dp[idx+1][txn+1];
                    int notBuy=0+dp[idx+1][txn];
                    dp[idx][txn]=Math.max(buy,notBuy);                
                }else{
                    int sell=prices[idx]+dp[idx+1][txn+1];
                    int notSell=0+dp[idx+1][txn];
                    dp[idx][txn]=Math.max(sell,notSell);
                }    
            }
        }
        return dp[0][0];
    }
}