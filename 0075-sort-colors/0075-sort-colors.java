class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0,r=n-1,mid=0;
        while(mid<=r){
            if(nums[mid]==0){
                swap(nums,l,mid);
                l++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;

            }else {
                swap(nums,mid,r);
                r--;
            }
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}