class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max1=nums[n-1];
        int max2=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=max1){
                max2=nums[i];
                break;
            }
        }
        return (max1-1)*(max2-1);
    }
}