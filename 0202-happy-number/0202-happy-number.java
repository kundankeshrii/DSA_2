class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=findSquare(slow);
            fast=findSquare(findSquare(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }else {
            return false;
        }
    }
    private int findSquare(int n){
        int sum=0;
        while(n>0){
            int r=n%10;
            sum+=r*r;
            n/=10;
        }
        return sum;
    }
}