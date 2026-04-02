class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>ans=new ArrayList<>();
        HashMap<String,Integer>mpp=new HashMap<>();
        int wordLen=words[0].length();
        int wordCount=words.length;
        int windowSize=wordCount*wordLen;
        for(String w : words){
            mpp.put(w,mpp.getOrDefault(w,0)+1);
        }
        for(int i=0;i<wordLen;i++){
            int left=i;
            int cnt=0;
            HashMap<String,Integer>windowMap=new HashMap<>();
            for(int right=i;right+wordLen<=s.length();right+=wordLen){
                String word=s.substring(right,right+wordLen);
                if(mpp.containsKey(word)){
                    windowMap.put(word,windowMap.getOrDefault(word,0)+1);
                    cnt++;

                    while(windowMap.get(word)>mpp.get(word)){
                        String leftWord=s.substring(left,left+wordLen);
                        windowMap.put(leftWord,windowMap.get(leftWord)-1);
                        left+=wordLen;
                        cnt--;
                    }
                    if(cnt==wordCount){
                        ans.add(left);
                    }

                    }else{
                        windowMap.clear();
                        cnt=0;
                        left=right+wordLen;
                    }
                }
            }
            return ans;
    }
}