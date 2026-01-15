class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH=maxGap(hBars);
        int maxV=maxGap(vBars);
        int side=Math.min(maxH,maxV);
        return side*side;
    }
    private int maxGap(int[] bars){
        Arrays.sort(bars);
        int maxConsecutive=1;
        int curr=1;
        for(int i=1;i<bars.length;i++){
            if(bars[i]==bars[i-1]+1){
                curr++;
                maxConsecutive=Math.max(curr,maxConsecutive);
            }else{
                curr=1;
            }
        }
        return maxConsecutive+1;
        }
}