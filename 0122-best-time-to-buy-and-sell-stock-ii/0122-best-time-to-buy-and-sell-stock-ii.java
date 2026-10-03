class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[]prev=new int[2];
        for(int idx=n-1;idx>=0;idx--){
            int[]curr=new int[2];
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    int take=-prices[idx]+prev[0];
                    int notTake=prev[1];
                    curr[buy]=Math.max(take,notTake);
                }else{
                    int sell=prices[idx]+prev[1];
                    int notSell=prev[0];
                    curr[buy]=Math.max(sell,notSell);
                }
                 
            }
            prev=curr;
        }
        return prev[1];
    }
}