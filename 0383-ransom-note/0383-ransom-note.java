class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer>mpp=new HashMap<>();
        for(char c:magazine.toCharArray()){
            mpp.put(c,mpp.getOrDefault(c,0)+1);
        }
        for(char c:ransomNote.toCharArray()){
           if(!mpp.containsKey(c) || mpp.get(c)==0){
              return false;
           }
           mpp.put(c,mpp.get(c)-1);
        }
        return true;
    }
}