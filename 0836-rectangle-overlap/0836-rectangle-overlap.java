class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int width=Math.min(rec2[2],rec1[2])-Math.max(rec1[0],rec2[0]);
        int height=Math.min(rec2[3],rec1[3])-Math.max(rec1[1],rec2[1]);
        return width>0 && height>0;
    }
}