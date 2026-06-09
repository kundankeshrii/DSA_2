class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt=0;
        int left=0;
        long prod=1;
        if(k<=1) return 0;//also most impo. edge case 
        for(int r=0;r<nums.length;r++){//r->right
            prod*=nums[r];
            while(prod>=k){
                prod/=nums[left];
                left++;
            }
            cnt+=r-left+1;//most important trick
        }
        return cnt;
    }
}