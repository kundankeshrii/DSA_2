class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int minIdx=-1;//5
        int max=Integer.MIN_VALUE;
        int maxIdx=-1;//1
        for(int i=0;i<nums.length;i++){
            if(min>nums[i]){
                min=nums[i];
                minIdx=i;
            }
            if(max<nums[i]){
                max=nums[i];
                maxIdx=i;
            }
        }
         
        int idxMin=Math.min(minIdx,maxIdx);//6
        int idxMax=Math.max(minIdx,maxIdx);//11
        int fL=idxMin+1;
        int fR=n-idxMax;
        int ans1=fL+fR;
        int ans2=idxMax+1;
        int ans3=n-idxMin;
         
        return Math.min(ans1,Math.min(ans2,ans3));
        
        }
    }
