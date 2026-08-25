class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i=k;i<=k*100;i+=k){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length+1;
    }
}