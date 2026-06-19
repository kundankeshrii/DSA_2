class Solution {
    public int largestAltitude(int[] gain) {
        int ans=0;
        int max=0;
        for(int i=0;i<gain.length;i++){
            ans=ans+gain[i];
            max=Math.max(ans,max);
        }
        return max;
    }
}