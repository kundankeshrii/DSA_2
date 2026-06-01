class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        int min=0;
        Arrays.sort(cost);
        for(int l=0,r=n-1;l<r;l++,r--){
            int temp=cost[l];
            cost[l]=cost[r];
            cost[r]=temp;
        }
        for(int i=0;i<n;i++){
            if(i%3!=2){
                min+=cost[i];
            }
        }
    
        return min;
    }
}