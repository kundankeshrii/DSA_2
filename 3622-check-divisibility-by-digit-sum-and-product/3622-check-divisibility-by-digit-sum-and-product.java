class Solution {
    public boolean checkDivisibility(int n) {
        int prod=1;
        int sum=0;
        int org=n;
        while(n>0){
            int r=n%10;
            sum+=r;
            prod*=r;
            n/=10;
        }
        return org%(prod+sum)==0;
    }
}