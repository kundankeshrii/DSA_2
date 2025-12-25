class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum=0;
        int decrement=0;
        int n=happiness.length;
        Arrays.sort(happiness);
        for(int i= n-1;i>=0 && k>0;i--){
            int curr=happiness[i]-decrement; 
            if(curr<0) break;
            sum+=curr;
            decrement++;
            k--;
        }
         return sum;
    }
}