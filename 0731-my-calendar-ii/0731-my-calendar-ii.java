class MyCalendarTwo {
    List<int[]>overlaps;
    List<int[]>bookings;
    public MyCalendarTwo() {
        overlaps=new ArrayList<>();
        bookings=new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] interval:overlaps){
            int left=Math.max(startTime,interval[0]);
            int right=Math.min(endTime,interval[1]);
            if(left<right){
                return false;
            }
        }
        for(int[] interval:bookings){
            int left=Math.max(startTime,interval[0]);
            int right=Math.min(endTime,interval[1]);
            if(left<right){
                overlaps.add(new int[]{left,right});
            }
        }
        bookings.add(new int[]{startTime,endTime});
        return true;

    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */