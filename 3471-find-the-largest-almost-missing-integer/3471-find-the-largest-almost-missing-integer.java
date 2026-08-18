class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer>mpp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<=n-k;i++){
            Set<Integer>set=new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(nums[j]);
            }
            for(int l:set){
                mpp.put(l,mpp.getOrDefault(l,0)+1);
            }
        }
        int ans=-1;
        for(Map.Entry<Integer,Integer>e:mpp.entrySet()){
            if(e.getValue()==1){
                int temp=e.getKey();
                if(temp>ans){
                    ans=temp;
                }
            }
        }
        return ans;
    }
}