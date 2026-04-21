class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax=0,maxSum=Integer.MIN_VALUE;
        int currMin=0,minSum=Integer.MAX_VALUE;
        int totalSum=0;
        for(int num:nums){
            //kadane for max
            currMax=Math.max(num,currMax+num);
            maxSum=Math.max(maxSum,currMax);
            //kadane for min
            currMin=Math.min(num,currMin+num);
            minSum=Math.min(currMin,minSum);
            totalSum+=num;
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum,totalSum-minSum);
    }
}