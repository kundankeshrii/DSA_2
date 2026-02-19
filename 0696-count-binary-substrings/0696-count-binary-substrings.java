class Solution {
    public int countBinarySubstrings(String s) {
        int n=s.length();
        int ans=0;
        int prev=0;
        int curr=1;
        for(int i=1;i<n;i++){
             if(s.charAt(i)==s.charAt(i-1)){
                curr++;
             }else{
                ans+=Math.min(curr,prev);
                prev=curr;
                curr=1;
              }
            }
        return ans+Math.min(prev,curr);
    }
}