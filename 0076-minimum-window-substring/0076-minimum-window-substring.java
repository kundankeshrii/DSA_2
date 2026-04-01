class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int cnt=t.length();
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int start=0;
        int[] freq=new int[128];//for ascii fixed values
        for(char c:t.toCharArray()){
            freq[c]++;
        }
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(freq[ch]>0){
                cnt--;
            }
            freq[ch]--;//include this in window
            while(cnt==0){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    start=left;
                }
                char leftChar=s.charAt(left);
                freq[leftChar]++;//remove from window
                if(freq[leftChar]>0){
                    cnt++;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "":s.substring(start,start+minLen);
    }
}