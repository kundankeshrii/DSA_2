class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        }
        int maxFreq = 0;
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxFreq) {
                maxFreq = freq;
                ans = num;
            }
            else if (freq == maxFreq && num < ans) {
                ans = num;
            }
        }
        return ans;
    }
}