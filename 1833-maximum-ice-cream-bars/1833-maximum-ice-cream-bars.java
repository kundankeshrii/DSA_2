class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        int currCost=0;
        int cnt=0;
        Arrays.sort(costs);
        for(int i=0;i<n;i++){
            currCost+=costs[i];
            if(currCost<=coins){
                cnt++;
            }else if(currCost>coins){
                break;
            }
        }
        return cnt;
    }
}