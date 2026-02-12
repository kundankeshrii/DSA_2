class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int sum=0;
        int stn=0;//Sum till i-1
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum-nums[0]==0) return 0;
        int result=sum;
        for(int i=1;i<n;i++){
            stn+=nums[i-1];
            sum=sum-nums[i]-stn;
            if(sum==stn){
                 return i;
            }
            sum=result;
        }
        return -1;
    }
}