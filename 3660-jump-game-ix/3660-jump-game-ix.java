class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        // prefix maximum
        int[] preMax=new int[n];
        preMax[0]=nums[0];
        for (int i = 1; i < n; i++) {
            preMax[i]=Math.max(preMax[i-1],nums[i]);
        }
        int[] ans=new int[n];
        int sufMin=Integer.MAX_VALUE;
        // suffix ke liye hamesha right to left hi jate hai 
        for(int i=n-1;i>=0;i--) {
            // if a smaller value exists on right,
            // this index belongs to the connected chain
            if(preMax[i]>sufMin){
                if(i+1<n){
                    ans[i]=ans[i+1];
                }else{
                    ans[i]=preMax[i];
                }
            }else{
                ans[i]=preMax[i];
            }
            // update suffix minimum
            sufMin=Math.min(sufMin,nums[i]);
        }
        return ans;
    }
}