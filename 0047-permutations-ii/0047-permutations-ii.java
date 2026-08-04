class Solution {
    List<List<Integer>>ans;
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited=new boolean[nums.length];
        ans=new ArrayList<>();
        Arrays.sort(nums);
        fun(nums,new ArrayList<>());
        return ans;
    }
    private void fun(int[] nums,List<Integer>path){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && !visited[i-1]) continue;
            visited[i]=true;
            path.add(nums[i]);
            fun(nums,path);
            path.remove(path.size()-1);
            visited[i]=false;
        }
    }
}