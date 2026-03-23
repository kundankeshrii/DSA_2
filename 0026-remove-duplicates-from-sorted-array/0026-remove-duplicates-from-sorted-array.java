class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int i=0,j=i+1;
        int cnt=0;
        while(j<n){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j++];
            }
            else{
                cnt++;
                j++;
            }
        }
        return n-cnt;
    }
}