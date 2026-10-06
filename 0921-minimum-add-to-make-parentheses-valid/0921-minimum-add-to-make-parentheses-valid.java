class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int open=0;
        int size=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                size++;
            }else if(size>0){
                size--;
            }else{
                open++;
            }
        }
    return open+size; 
    }
         
}