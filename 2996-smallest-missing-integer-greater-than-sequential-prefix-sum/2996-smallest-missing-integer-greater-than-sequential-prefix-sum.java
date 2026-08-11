class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        Set<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }else{
                
                break;
            }
        }
        int i=0;
        while(i<=n){
            if(!set.contains(sum)){
                return sum;
            }else{
                sum=sum+1;
                i++;
            }
        }
        return -1;
    }
}