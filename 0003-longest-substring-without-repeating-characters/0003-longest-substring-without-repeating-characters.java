class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maax=Integer.MIN_VALUE;
        if(s.length()==0){
            return 0;
        }
        for(int i=0;i<s.length();i++){
          Set<Character> se = new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(se.contains(s.charAt(j))){
                    maax=Math.max(maax,j-i);
                    break;
                }
                else{
                    se.add(s.charAt(j));
                }
            }
             maax = Math.max(maax, se.size());
        }
        return maax;
    }
}