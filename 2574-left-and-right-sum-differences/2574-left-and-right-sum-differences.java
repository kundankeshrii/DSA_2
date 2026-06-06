class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[]suffix=new int[n];
        int suff=0;
        for(int i=n-1;i>=0;i--){
            suff+=nums[i];
            suffix[i]=suff;
        }
        int[] prefix=new int[n];
        int pref=0;
        for(int i=0;i<n;i++){
            pref+=nums[i];
            prefix[i]=pref;
        }
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(prefix[i]-suffix[i]);
        }
        return nums;
    }
}