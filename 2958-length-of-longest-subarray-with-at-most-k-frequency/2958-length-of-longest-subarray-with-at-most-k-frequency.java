class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l=0;
        int n=nums.length;
        int max=-1;
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int r=0;r<n;r++){
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            while(mpp.get(nums[r])>k){
                mpp.put(nums[l],mpp.get(nums[l])-1);
                l++;
            }
            max=Math.max(max,r-l+1);
           
        }
        return max;
    }
}