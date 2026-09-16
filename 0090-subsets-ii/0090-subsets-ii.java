class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>result=new ArrayList<>();
        powerSet(nums,0,new ArrayList<>(),result);
        return result;
    }

    private List<List<Integer>> powerSet(int[] nums,int idx,List<Integer> ds,List<List<Integer>>result ){
            result.add(new ArrayList<>(ds));
        for(int i=idx;i<nums.length;i++){
            if(i!=idx && nums[i]== nums[i-1]) continue;
                ds.add(nums[i]);
                powerSet(nums,i+1,ds,result);
                ds.remove(ds.size()-1);
            }
            return result;
        }
}