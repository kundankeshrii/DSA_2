class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        fun(0, temp,ans,nums);
        return ans;
    }private void fun(int idx,List<Integer>temp,List<List<Integer>>ans,int[]nums){
        if(idx==nums.length){
            ans.add(new ArrayList<>(temp));
             return ;
        }

        temp.add(nums[idx]);
        fun(idx+1,temp,ans,nums);

        temp.remove(temp.size()-1);
        
        fun(idx+1,temp,ans,nums);
    }
}