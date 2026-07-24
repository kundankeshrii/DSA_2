class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int T=1;
        while(T<=max){
            T*=2;
        }

        boolean[] s1=new boolean[T];
        boolean[] s2=new boolean[T];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                s1[nums[i]^nums[j]]=true;
            }
        }
        for(int i=0;i<T;i++){
            if(s1[i]==true){
                for(int num:nums){
                    s2[i^num]=true;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<T;i++){
            if(s2[i]==true){
                cnt++;
            }
        }
        return cnt;
    }
}