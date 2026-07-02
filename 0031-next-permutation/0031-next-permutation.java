class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int gola_idx=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                gola_idx=i-1;
                break;
            }
        }
        int swapIdx=gola_idx;
        for(int j=n-1;j>=gola_idx;j--){
            if(gola_idx!=-1 && nums[gola_idx]<nums[j]){
                swapIdx=j;
                break;
            }
        }
        if(gola_idx!=-1) swap(nums,gola_idx,swapIdx);
         
        reverse(nums,gola_idx+1,n-1);
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private void reverse(int[] arr,int i, int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}