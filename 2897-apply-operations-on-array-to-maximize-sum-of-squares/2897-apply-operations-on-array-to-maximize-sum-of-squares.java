class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long m=1000000007;
        int n=nums.size();
        int[]count=new int[30];
        for(int num:nums){
            for(int j=0;j<30;j++){
                if((num & 1<<j)!=0){
                    count[j]++;
                }
            }
        }
        long ans=0;
        while(k-->0){
            long curr=0;
            for(int b=0;b<30;b++){
                if(count[b]>0){
                    count[b]--;
                    curr=curr|(1<<b);
                }
            }
            ans+=(curr*curr)%m;
        }
        return (int)(ans%m);
    }
}