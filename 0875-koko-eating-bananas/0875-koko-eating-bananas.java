class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi=piles[0];

        for(int pile:piles){
            maxi=Math.max(pile,maxi);
        }

         int low=1;
         int high=maxi;

         while(low<high){
            int mid=low+(high-low)/2;
            long hours=findHours(piles,mid);
            if(hours<=h){
                high=mid;
            }else{
                low=mid+1;
            }
         }
         return low;
    }
    private long findHours(int[] arr,int speed){
        long totalHour=0;
        for(int i=0;i<arr.length;i++){
            totalHour+=(long)Math.ceil((double)arr[i]/speed);
        }
        return totalHour;
    }
}