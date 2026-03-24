class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        n=n/2;
        for(Map.Entry<Integer,Integer>e:mpp.entrySet()){
            if(e.getValue()>n){
                return e.getKey();
            }
        }
        return -1;
    }
}