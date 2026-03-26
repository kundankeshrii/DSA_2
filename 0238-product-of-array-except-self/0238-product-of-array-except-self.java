class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int sufix=1;
        int[] suffix=new int[n];
        for(int i=n-1;i>=0;i--){
            suffix[i]=sufix;
            sufix=sufix*nums[i];
        }
        int prefix=1;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=suffix[i]*prefix;
            prefix=prefix*nums[i];
        }
        return ans;
    }
}