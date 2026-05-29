class Solution {
    public int minElement(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int sum=0;
            while(num>0){
                int r=num%10;
                sum+=r;
                num/=10;
            }
            if(min>sum){
                min=sum;
            }
        }
        return min;
    }
}