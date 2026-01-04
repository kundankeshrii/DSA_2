class Solution {
    private int factor(int n){
        int i=1;
        int sum=0;
        int cnt=0;
        // int sqRoot=Math.sqrt(n);
        while(i<=n){
            if(n%i==0){
                cnt++;
                sum+=i;
                if(cnt>4) break;
            }
            i++;
        }
        if (cnt==4) return sum;
        else return 0;
    }
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int Fsum=0;
        for(int i=0;i<n;i++){
          Fsum+=factor(nums[i]);
        }
        return Fsum;
    }
}