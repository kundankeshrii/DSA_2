class Solution {
    public int longestSubsequence(int[] nums) {
        int maxCnt=0;
        for(int i=0;i<nums.length;i++){
                maxCnt^=nums[i];
        }
        boolean allZero=true;
        for(int num:nums){
            if(num!=0){
            allZero=false;
            break;
            }
        }
            if(maxCnt!=0){
                return nums.length;
            }else if(!allZero){
              return  nums.length-1;
            }else return 0;
    }
}