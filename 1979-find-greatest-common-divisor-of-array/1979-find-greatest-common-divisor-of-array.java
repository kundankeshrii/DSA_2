class Solution {
    public int findGCD(int[] nums) {
        int s=nums[0];
        int l=nums[0];
        for(int i=0;i<nums.length;i++){
            s=Math.min(s,nums[i]);
            l=Math.max(l,nums[i]);
        }
        return gcd(s,l);
    }
    private int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}