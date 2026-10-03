class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]after=new int[2][3];
        for(int idx=n-1;idx>=0;idx--){
            int[][]curr=new int[2][3];
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        int take=-prices[idx]+after[0][cap];
                        int notTake=after[1][cap];
                        curr[buy][cap]=Math.max(notTake,take);
                    }else{
                        int sell=prices[idx]+after[1][cap-1];
                        int notSell=after[0][cap];
                        curr[buy][cap]=Math.max(sell,notSell);
                    }
                    
                }
            }
            after=curr;
        }
        return after[1][2];
    }
}