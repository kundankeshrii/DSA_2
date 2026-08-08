class Solution {
    public long maxPairStrength(int[] nums) {
        int n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                    long gcdd=gcd(nums[i],nums[j]);
                    long gcdSq=gcdd*gcdd;
                    long prod=(long)nums[i]*nums[j];
                    long req=prod/gcdSq;
                    if(req>ans){
                        ans=req;
                    }
                }
            }
        return ans;
    }
    private long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}