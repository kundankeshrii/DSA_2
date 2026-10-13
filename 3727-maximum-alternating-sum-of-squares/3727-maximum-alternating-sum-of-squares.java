class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=Math.abs(nums[i]);
        }
        Arrays.sort(arr);
        long temp1=0;
        for(int i=0;i<arr.length/2;i++){
            temp1+=(long)(arr[i]*arr[i]);
        }
        long temp2=0;
        for(int i=arr.length/2;i<arr.length;i++){
            temp2+=(long)(arr[i]*arr[i]);
        }
        return temp2-temp1;
    }
}