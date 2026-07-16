class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        long[] prefixGcd=new long[n];
        long max=nums[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=gcd(nums[i],max);
        }
        Arrays.sort(prefixGcd);
        int i=0;
        int j=n-1;
        long ans=0;
        while(i<j){
            ans+=gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }
        return ans; 
    }
    private long gcd(long a, long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}