class Solution {
    public int minInsertions(String s) {
        int cnt=0;
        int req=0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                cnt++;
                i++;
            }else{
                if(cnt>0){
                    cnt--;
                }else{
                    req+=1;
                }
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    i+=2;
                }else{
                    req+=1;
                    i++;
                }
            }
        }
        return req+2*cnt;
    }
}