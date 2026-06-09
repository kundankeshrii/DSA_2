class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        //applying Deque 
        //just one change from standard question (q239)
        //just used dp[]
        int[]dp=nums.clone();
        Deque<Integer>dq=new ArrayDeque<>();
        int maxR=dp[0];
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty()  && dq.peekFirst()<i-k){
                dq.pollFirst();
            }
            if(!dq.isEmpty()){
                dp[i]=Math.max(dp[i],nums[i]+dp[dq.peekFirst()]);
            }
            while(!dq.isEmpty() && dp[i]>=dp[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
             
             maxR=Math.max(dp[i],maxR);
        }
         
        return maxR;
    }
}