class Solution {
    public boolean canJump(int[] nums) {
        int maxIndRec=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxIndRec) return false;
            maxIndRec=Math.max(maxIndRec,i+nums[i]);
        }
        return true;
    }
}