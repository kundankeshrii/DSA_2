class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxValue=Arrays.stream(nums).max().getAsInt();
         int low=1;
         int high=maxValue;
         int ans=maxValue;
         while(low<=high){
            int mid=low+(high-low)/2;
            long hours=findHours(nums,mid);
            if(hours<=threshold){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
         }
         return ans;
    }
    private long findHours(int[] arr,int hourly){
        long totalHour=0;
        for(int i=0;i<arr.length;i++){
            totalHour+=(long)Math.ceil((double)arr[i]/hourly);
        }
        return totalHour;
    }
}