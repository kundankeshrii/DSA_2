class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer>list=new ArrayList<>(mpp.keySet());
            Collections.sort(list,(a,b)->mpp.get(b)-mpp.get(a));
            int[]ans=new int[k];
            for(int i=0;i<k;i++){
                ans[i]=list.get(i);
            }
        return ans;
    }
}