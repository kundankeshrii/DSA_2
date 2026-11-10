class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>ans=new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    ans.add(List.of(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                }
            }

        }
        return new ArrayList<>(ans);
    }
}