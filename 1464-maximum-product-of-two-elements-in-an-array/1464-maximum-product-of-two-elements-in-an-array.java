class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max1=0;
        int max1Idx=-1;
        for(int i=0;i<n;i++){
            if(nums[i]>max1){
                max1=nums[i];
                max1Idx=i;
            }
        }
        int max2=0;
        for(int i=0;i<n;i++){
            if(nums[i]>=max2 && i!=max1Idx){
                max2=nums[i];
            }
        }
        return (max1-1)*(max2-1);
    }
}