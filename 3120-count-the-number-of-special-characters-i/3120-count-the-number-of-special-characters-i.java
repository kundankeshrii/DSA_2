class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character>setS=new HashSet<>();
        HashSet<Character>setC=new HashSet<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                setS.add(ch);
            }else if(ch>='A' && ch<='Z'){
                setC.add((char)(ch+32));
            }
        }
        int cnt=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(setC.contains(ch) && setS.contains(ch)) cnt++;
            setC.remove(ch);
            setS.remove(ch);
        }
        return cnt;
    }
}