class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        Map<Character,Integer>mpp=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        int reqCnt=t.length();
        int i=0,j=0;
        int start_idx=0;
        int minWindowSize=Integer.MAX_VALUE;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(mpp.containsKey(ch) && mpp.get(ch)>0){
                reqCnt--;
            }
            mpp.put(ch,mpp.getOrDefault(ch,0)-1);
            while(reqCnt==0){
                int currWindowSize=j-i+1;
                if(minWindowSize>currWindowSize){
                    minWindowSize= currWindowSize;
                    start_idx=i;
                }

                char left=s.charAt(i);
                mpp.put(left,mpp.getOrDefault(left,0)+1);
                if(mpp.containsKey(left) && mpp.get(left)>0){
                    reqCnt++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize==Integer.MAX_VALUE ? "":s.substring(start_idx,start_idx+minWindowSize);

    }
}