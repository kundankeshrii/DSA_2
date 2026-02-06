class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int answer=0;
        int j=0;
        for(int i=0;i<n;i++){
            while(j<n && nums[j]<=(long)k*nums[i]){
                j++;
             }
             answer=Math.max(answer,j-i);
        }
        return n-answer;
    }
}