class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch!='*'){
                sb.append(ch);
            }
            else if(ch=='*'){
                sb.deleteCharAt(sb.toString().length()-1);
            }
        }
        return sb.toString();
    }
}