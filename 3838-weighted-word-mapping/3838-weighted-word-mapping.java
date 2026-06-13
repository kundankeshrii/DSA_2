class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        Map<Integer,Character>mpp=new HashMap<>();
        String s="";
        for(int i=0;i<26;i++){
            char ch=(char)('z'-i);
            mpp.put(i,ch);
        }
        for(String word:words){
            int sum=0;
             for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                int idx=(int)(ch-'a');
                sum+=weights[idx];
             }
             sum=sum%26;
             char c=mpp.get(sum);
            s=s+c;
        }
        return s;
    }
}