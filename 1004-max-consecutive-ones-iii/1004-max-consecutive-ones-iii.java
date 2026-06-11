class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        int left=0;
        int zero=0;
        for(int r=0;r<n;r++){
            if(nums[r]==0){
                zero++;
            }
            while(zero>k){
                if(nums[left]==0){
                     zero--;
                }
                left++;
            }if(zero<=k){
                max=Math.max(max,r-left+1);
            }

        }
        return max;
    }
}