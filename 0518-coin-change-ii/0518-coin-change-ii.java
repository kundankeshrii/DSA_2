class Solution {
    public int change(int amount, int[] arr) {
        int n=arr.length;
        int[] prev=new int[amount+1];
        for(int target=0;target<=amount;target++){
            if(target%arr[0]==0){
                prev[target]=1;
            }
        }
        for(int idx=1;idx<n;idx++){ 
            int[] curr=new int[amount+1];
            for(int target=0;target<=amount;target++){
                int notTake=prev[target];
                int take=0;
                if(arr[idx]<=target){
                    take=curr[target-arr[idx]];
                }
                curr[target]=notTake+take;
            }
            prev=curr;
        }
        return prev[amount];
    }
}