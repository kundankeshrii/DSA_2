class Solution {
    public int rotatedDigits(int n) {
        int cnt=0;
        for(int num=1;num<=n;num++){
            if(checkGood(num)){
                cnt++;
            }
        }
        return cnt;
    }
    private boolean checkGood(int num){
        boolean hasChanged=false;
        while(num>0){
            int rem=num%10;
            if(rem==3 || rem==4 || rem==7){
                return false;
            }
            if(rem==2 || rem==5 ||rem==6 || rem==9){
                hasChanged=true;

            }
            num/=10;
        }
        return hasChanged;
    }
}