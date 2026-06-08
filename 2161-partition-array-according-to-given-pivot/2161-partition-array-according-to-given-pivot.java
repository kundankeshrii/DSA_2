class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        List<Integer>list3=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                list1.add(nums[i]);
            }else if(nums[i]==pivot){
                list2.add(nums[i]);
            }else if(nums[i]>pivot){
                list3.add(nums[i]);
            }
        }
        for(int i=0;i<list2.size();i++){
            list1.add(list2.get(i));
        }
        for(int i=0;i<list3.size();i++){
            list1.add(list3.get(i));
        }
        for(int i=0;i<list1.size();i++){
            nums[i]=list1.get(i);
        }
         
        return nums;
    }
}