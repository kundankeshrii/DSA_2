class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        if(n!=max+1) return false;
        int[] freq=new int[201];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=1;i<max;i++){
            if(freq[i]!=1) return false;
        }
         return freq[max]==2;
    }
}