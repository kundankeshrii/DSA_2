class Solution {
    public boolean isIsomorphic(String s, String t) {
          HashMap<Character,Character>mppST=new HashMap<>();
          HashMap<Character,Character>mppTS=new HashMap<>();
          for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(mppST.containsKey(c1)){
                if(mppST.get(c1)!=c2){
                    return false;
                }
                }else{
                    mppST.put(c1,c2);
                }
            if(mppTS.containsKey(c2)){
                if(mppTS.get(c2)!=c1) return false;
            }
            else mppTS.put(c2,c1);
          }
            return true;
    }
}