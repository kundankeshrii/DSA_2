class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<=1) return nums[n-1];
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            list1.add(nums[i]);
        }
        for(int i=1;i<n;i++){
            list2.add(nums[i]);
        }
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
         for(int i=0;i<list1.size();i++){
            temp1[i]=list1.get(i);
            temp2[i]=list2.get(i);
         }
        return Math.max(fun(temp1),fun(temp2));
    }
    private int fun(int[] nums){
        int n=nums.length;
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1) pick+=prev2;
            int notPick=0+prev1;
            int curri=Math.max(pick,notPick);
            prev2=prev1;
            prev1=curri;
        }
        return prev1;
    }
}