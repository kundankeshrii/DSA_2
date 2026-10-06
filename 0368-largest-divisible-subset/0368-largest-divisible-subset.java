class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int maxi=1;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        int lastIdx=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && dp[i]<1+dp[prev]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                    lastIdx=i;
                }
            }
        }
        List<Integer>list=new ArrayList<>();
        list.add(nums[lastIdx]);
        while(hash[lastIdx]!=lastIdx){
            lastIdx=hash[lastIdx];
            list.add(nums[lastIdx]);
        }
        Collections.reverse(list);
        return list;
    }
}