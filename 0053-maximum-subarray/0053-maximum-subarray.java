class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int maxCnt=Integer.MIN_VALUE;
        int currCnt=0;
        for(int i=0;i<n;i++){
            currCnt+=nums[i];
            maxCnt=Math.max(currCnt,maxCnt);
            if(currCnt<0){
                currCnt=0;
            }
        }
        return maxCnt;
    }
}