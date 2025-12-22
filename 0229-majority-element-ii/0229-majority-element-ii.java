class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0,ele1=Integer.MIN_VALUE;
        int cnt2=0,ele2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && ele2!=nums[i]){
                cnt1++;
                ele1=nums[i];
            }
            else if(cnt2==0 && ele1!=nums[i]){
                cnt2++;
                ele2=nums[i];
            }else if(ele1==nums[i]) cnt1++;
            else if(ele2==nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1) cnt1++;
            if(nums[i]==ele2) cnt2++;
        }
        int mini = (nums.length/3)+1;
        List<Integer>ans=new ArrayList<>();
        if(cnt1>=mini) ans.add(ele1);
        if(cnt2>=mini) ans.add(ele2);
        return ans;
    }
}
