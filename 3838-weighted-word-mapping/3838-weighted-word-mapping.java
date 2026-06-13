class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        for(String word:words){
            int sum=0;
            for(char ch:word.toCharArray()){
                sum+=weights[ch-'a'];
            }
            int mod=sum%26;
            char finalChar=(char)('z'-mod);
            sb.append(finalChar);
        }
        return sb.toString();
    }
}