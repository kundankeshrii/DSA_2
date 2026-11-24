class Solution {
    public int maxLength(int[] nums){
        int size=0;
        for(int i=0;i<nums.length;i++){
            long prod = 1;
            long gcdVal = 0;
            long lcmVal = 1;
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                gcdVal = gcd(gcdVal, nums[j]);
                lcmVal = lcm(lcmVal, nums[j]);
                if(prod==gcdVal*lcmVal){
                    size=Math.max(size,j-i+1);
                }
            }
            
        }
        return size;
    }
    private long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return Math.abs(a);
    }
    private long lcm(long a, long b){
        if(a==0 || b==0) return 0;
        return (Math.abs(a)/gcd(a,b))*b;
    }
}