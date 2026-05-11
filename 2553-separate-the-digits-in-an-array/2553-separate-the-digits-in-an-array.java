class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<nums.length;i++){
            sb.append(nums[i]);
        }
        char[]arr=sb.toString().toCharArray();
        int [] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=(int)(arr[i]-'0');
        }
        return ans;
    }
}