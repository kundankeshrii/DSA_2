class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        int k=3;
        for(int i=0;i<32;i++){
            int sum=0;
            for(int num:nums){
                if(((num>>i)&1)==1){
                    sum++;
                }
            }
            if(sum%k!=0){
                result|=(1<<i);
            }
        }
        return result;
    }
}