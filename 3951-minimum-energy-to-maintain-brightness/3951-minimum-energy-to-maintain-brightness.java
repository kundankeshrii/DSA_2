class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int need=(int)Math.ceil(brightness/3.0);
        long range=0;
        int[][]newIntervals=merge(intervals);

        for(int[] interval:newIntervals){
            int l=interval[0];
            int r=interval[1];
            range+=(r-l)+1;
        }
        return need*range;
    }
    private int[][] merge(int[][] intervals) {
        List<int[]>ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }else{
                ans.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        ans.add(new int[]{start,end}); 
        int n=ans.size();
        int[][] arr=new int[n][2];
        for (int i = 0; i < ans.size(); i++) {
                 arr[i] = ans.get(i);
                }
        return arr;
    }
}