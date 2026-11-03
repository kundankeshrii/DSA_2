class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int total=0;
        for(int i=0;i<n;i++){
            total+=max-nums[i];
        }
        return total;
    }
}