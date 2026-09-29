class Solution {
    public int change(int amount, int[] arr) {
        int n=arr.length;
        int[][]dp=new int[n][amount+1];
        for(int target=0;target<=amount;target++){
            if(target%arr[0]==0){
                dp[0][target]=1;
            }
        }
        for(int idx=1;idx<n;idx++){ 
            for(int target=0;target<=amount;target++){
                int notTake=dp[idx-1][target];
                int take=0;
                if(arr[idx]<=target){
                    take=dp[idx][target-arr[idx]];
                }
                dp[idx][target]=notTake+take;
            }
        }
        return dp[n-1][amount];
    }
}