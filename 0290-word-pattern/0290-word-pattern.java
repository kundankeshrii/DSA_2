class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        if(pattern.length() != words.length) return false;
        HashMap<Character,String> mppPT=new HashMap<>();
        HashMap<String,Character> mppTP=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            String word=words[i];

            if(mppPT.containsKey(c)){
                if(!mppPT.get(c).equals(word)) return false;
            }else{
                mppPT.put(c,word);
            }

            if(mppTP.containsKey(word)){
                if(mppTP.get(word)!=c) return false;
            }else{
                mppTP.put(word,c);
            }
        }
        return true;
    }
}