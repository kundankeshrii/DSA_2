class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long sum=0;
        int l=0;
        long maxSum=0;
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int r=0;r<n;r++){
            sum+=nums[r];
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            if(r-l+1>k){
                sum-=nums[l];
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                }
                l++;
            }
            if(r-l+1==k && mpp.size()==k){
                maxSum=Math.max(sum,maxSum);
            }

        }
        return maxSum;
    }
}