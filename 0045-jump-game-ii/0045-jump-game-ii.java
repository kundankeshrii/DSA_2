class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumpCnt=0;
        int maxInd=0;
        int currEnd=0;
        for(int i=0;i<n-1;i++){
            //explore karo aur maxInd find karo
            maxInd=Math.max(maxInd,i+nums[i]);
            //explore kar liya aab jump karo
            if(i==currEnd){
                jumpCnt++;
                currEnd=maxInd;
            }
        }
        return jumpCnt;
    }
}