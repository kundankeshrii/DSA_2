class Solution {
    public int subarraySum(int[] nums, int k) {
         HashMap<Integer,Integer>mpp=new HashMap<>();
         int prefixSum=0;
         int cnt=0;
         mpp.put(0,1);
         for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int removed=prefixSum-k;
            if(mpp.containsKey(removed)){
                cnt+=mpp.get(removed);
            }
            mpp.put(prefixSum,mpp.getOrDefault(prefixSum,0) + 1);
         }
         return cnt;
    }
}