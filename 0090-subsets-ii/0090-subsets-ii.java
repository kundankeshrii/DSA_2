class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        Arrays.sort(nums);
        fun(0,temp,ans,nums);
        return ans;
        
    }
    private void fun(int idx,List<Integer>temp,List<List<Integer>>ans,int[] nums){
        ans.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            fun(i+1,temp,ans,nums);
            temp.remove(temp.size()-1);
        }
    }
}