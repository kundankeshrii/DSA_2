class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<Integer>ans=new ArrayList<>();
        if(n==(nums[n-1]-nums[0])+1) return ans;
        Set<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i=nums[0];i<=nums[n-1];i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;

        
    }
}