class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>mpp=new HashMap<>();
        int cumSum=0;
        int cnt=0;
        mpp.put(0,1);
        for(int num:nums){
            cumSum+=num;
            if(mpp.containsKey(cumSum-k)){
                cnt+=mpp.get(cumSum-k);
            }
            mpp.put(cumSum,mpp.getOrDefault(cumSum,0)+1);
        }
        return cnt;

    }
}