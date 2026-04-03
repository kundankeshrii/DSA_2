class Solution {
    public double myPow(double x, int n) {
        double ans=1;
        if(n==0){
            return 1;
        }
        if(n>0){
            ans=x*Math.pow(x,n-1);
        }else{
            ans=(1/x)*Math.pow(x,n+1);
        }
        return ans;
    }
}