class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used=new boolean[nums.length];
        backTrack(nums,new ArrayList<>());
        return ans;
    }
    private void backTrack(int[] nums,List<Integer>path){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;
            path.add(nums[i]);
            backTrack(nums,path);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}