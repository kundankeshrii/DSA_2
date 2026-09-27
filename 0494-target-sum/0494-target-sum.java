class Solution {
    public int findTargetSumWays(int[] arr, int diff) {
        int n = arr.length;
		int totalSum=0;
		for(int i:arr){
		    totalSum+=i;
		}
		if((totalSum-diff)<0 || (totalSum-diff)%2==1){
		    return 0;
		}
		int target= target=(totalSum-diff)/2;
		int[]prev = new int[target+1];
		prev[0] = 1;
		if (arr[0]<=target) prev[arr[0]]+=1;
		
		for (int idx = 1; idx<n; idx++){
			int[]curr = new int[target + 1];
			for (int sum = 0; sum <= target; sum++) {
				int notPick = prev[sum];
				int pick = 0;
				if (arr[idx] <= sum) {
					pick = prev[sum - arr[idx]];
				}
				curr[sum] = pick + notPick;
			}
			prev = curr;
		}
		
		return prev[target];
    }
}