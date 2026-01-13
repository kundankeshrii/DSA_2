class Solution {
    public double separateSquares(int[][] squares) {
        double low=Integer.MAX_VALUE;
        double high=Integer.MIN_VALUE;
        for(int []sq:squares){
            double y=sq[1];
            double l=sq[2];
            low=Math.min(low,y);
            high=Math.max(high,y+l);
        }
        for(int i=0;i<60;i++){
            double mid=(low+high)/2.0;
            double areaBelow=0.0;
            double areaAbove=0.0;
            for(int[] sq:squares){
                double bottom=sq[1];
                double top=sq[1]+sq[2];
                double side=sq[2];
                if(top<=mid){
                    areaBelow+=side*side;
                }else if(bottom>=mid){
                    areaAbove+=side*side;
                }
                else{
                    areaBelow+=side*(mid-bottom);
                    areaAbove+=side*(top-mid);
                }
            }
            if(areaBelow<areaAbove){
                low=mid;
            }else{
                high=mid;
            }
        }
        return low;
    }
}