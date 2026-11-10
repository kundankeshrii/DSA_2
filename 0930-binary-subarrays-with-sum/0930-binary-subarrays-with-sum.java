class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return fun(nums,goal)-fun(nums,goal-1);
    }
    private int fun(int[] nums,int goal){
        int n=nums.length;
        int left=0;
        int sum=0;
        int cnt=0;
        if(goal<0) return 0;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum>goal){
                sum=sum-nums[left];
                left++;
            }
            cnt+=right-left+1;
        }
        return cnt;
    }
}