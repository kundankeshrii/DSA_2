class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long profit[]=new long[n];
        long p=0;
        for(int i=0;i<n;i++){
            profit[i]=(long)prices[i]*strategy[i];
            p+=profit[i];
        }
        int i=0,j=0;
        int originalProfit=0;
        long ans=0;
        long modifiedProfit=0;
        while(j<n){
            originalProfit+=profit[j];
            if(j-i+1>k/2){
                modifiedProfit+=prices[j];
            }
            if(j-i+1>k){
                originalProfit-=profit[i];
                modifiedProfit-=prices[i+k/2];
                i++;
            }
            if(j-i+1==k){
                ans=Math.max(ans,modifiedProfit-originalProfit);
            }
            j++;
        }
        return p+ans;
    }
}