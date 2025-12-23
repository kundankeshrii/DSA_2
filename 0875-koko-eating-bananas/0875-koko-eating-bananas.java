class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int maxValue=Arrays.stream(piles).max().getAsInt();
         int low=1;
         int high=maxValue;
         int ans=maxValue;
         while(low<=high){
            int mid=low+(high-low)/2;
            long hours=findHours(piles,mid);
            if(hours<=h){
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