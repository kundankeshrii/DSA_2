class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            if(divisible(i,t)) return i;

        }
        return -1;
    }
    private boolean divisible(int n,int t){
        int prod=1;
        while(n>0){
            int r=n%10;
            prod=prod*r;
            n=n/10;
        }
        if(prod%t==0){
            return true;
        }
        return false;
    }
}