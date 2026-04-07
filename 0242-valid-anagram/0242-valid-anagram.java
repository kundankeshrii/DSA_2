class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer>mpp=new HashMap<>();
        for(char c:t.toCharArray()){
            mpp.put(c,mpp.getOrDefault(c,0)+1);
        }
        for(char c:s.toCharArray()){
            if(!mpp.containsKey(c) || mpp.get(c)==0){
                return false;
            }
           mpp.put(c,mpp.get(c)-1);
        }
        return true;
    }
}