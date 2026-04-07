class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int longest=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int current=num;
                int cnt=1;
                while(set.contains(current+1)){
                    current++;
                    cnt++;
                }
               longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
}
//step 1: sabko set me dalo
//step 2: traverse in set 
//apply the logic (num-1)
//step 3: proceed it until it continues
// step 4; find longest
// return it ;