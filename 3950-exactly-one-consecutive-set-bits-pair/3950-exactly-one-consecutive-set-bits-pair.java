class Solution {
    public boolean consecutiveSetBits(int n) {
        String s=Integer.toBinaryString(n);
        int check=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)=='1' && s.charAt(i)=='1'){
                 check++;
            }
        }
        return check==1?true: false;
    }
}