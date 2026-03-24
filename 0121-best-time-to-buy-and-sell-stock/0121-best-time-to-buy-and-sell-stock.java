class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxP=0;
        int minP=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<minP){
                minP=prices[i];
            }
            else if(prices[i]-minP>maxP){
                maxP=prices[i]-minP;
             }
         }
      return maxP;
     }
}