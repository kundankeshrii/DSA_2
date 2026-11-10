class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Set<Integer>set=new HashSet<>();
        for(int i:nums) set.add(i);
        int longest=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int curr=num;
                int cnt=1;
                while(set.contains(curr+1)){
                    curr++;
                    cnt++;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
}