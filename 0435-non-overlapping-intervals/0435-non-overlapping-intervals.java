class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int cnt=1;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
         int preEnd=intervals[0][1];
         for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=preEnd){
                cnt++;
                preEnd=intervals[i][1];
            }
         }
         return n-cnt;
    }
}