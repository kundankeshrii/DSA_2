class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int need=(int)Math.ceil(brightness/3.0);
        long range=0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }else{
                range+=(end-start)+1;
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        range+=(end-start)+1;
        return need*range;
    }
}