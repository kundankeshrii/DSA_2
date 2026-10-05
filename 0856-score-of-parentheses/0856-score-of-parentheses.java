class Solution {
    public int scoreOfParentheses(String s) {
        int previous=0;
        int score=0;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                list.add(score);
                score=0;
            }else{
                if(s.charAt(i-1)=='('){
                    score=list.get(list.size()-1)+1;
                }else{
                    score=list.get(list.size()-1)+(2*score);
                }
                list.remove(list.size()-1);
            }
        }
        return score;
    }
}