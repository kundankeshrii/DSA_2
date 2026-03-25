class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
      return fun(n,0,2,1);
    }
    private int fun(int n,int curri,int prev1,int prev2){
      for(int i=3;i<=n;i++){
         curri=prev1+prev2;
         prev2=prev1;
         prev1=curri;
      }
      return prev1;
    }
}