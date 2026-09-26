class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[]prev=new int[amount+1];
        for(int T=0;T<=amount;T++){
            if(T%coins[0]==0) prev[T]=T/coins[0];
            else prev[T]= (int)1e9;
        }
        for(int idx=1;idx<n;idx++){
            int[]curr=new int[amount+1];
            for(int target=0;target<=amount;target++){
                int notTake=0+prev[target];
                int take=Integer.MAX_VALUE;
                if(coins[idx]<=target){
                    take=1+curr[target-coins[idx]];
                }
                curr[target]=Math.min(take,notTake);
            }
            prev=curr;
        }
        return prev[amount]!=1e9?prev[amount]:-1;
    }
}