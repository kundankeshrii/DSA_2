class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i]-1!=i) return false;
        }
        if(n>1  && nums[n-1]==nums[n-2] && n-1==nums[n-1]) return true;
        return false;
    }
}