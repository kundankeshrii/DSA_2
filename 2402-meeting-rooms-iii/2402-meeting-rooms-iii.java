class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer>freeRoom=new PriorityQueue<>();
        PriorityQueue<long[]>busyRoom=new PriorityQueue<>((a,b)->
                  a[0]==b[0] ? Long.compare(a[1],b[1]) :Long.compare(a[0],b[0]));
        
        for(int i=0;i<n;i++){
            freeRoom.add(i);
        }
        int[] count=new int[n];
        //step:2
        for(int meeting[]: meetings){
            long start=meeting[0];
            long end=meeting[1];
            long duration=end-start;
            while(!busyRoom.isEmpty() && busyRoom.peek()[0]<=start){
                freeRoom.add((int)busyRoom.poll()[1]);
            }
            if(!freeRoom.isEmpty()){
                int room=freeRoom.poll();
                busyRoom.add(new long[]{end,room});
                count[room]++;
            }else{
                long[] earliest=busyRoom.poll();
                long newEnd=earliest[0]+duration;
                busyRoom.add(new long[]{newEnd,earliest[1]});
                count[(int)earliest[1]]++;
            }
        }
        int ans=0;
        for(int i=1;i<n;i++){
            if(count[i]>count[ans]){
                ans=i;
            }
        }
        return ans;
    }
}