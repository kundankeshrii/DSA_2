class Solution {
    public char processStr(String s, long k) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }else if(ch=='*'){
                int n=sb.toString().length();
                if(n!=0){
                  sb.deleteCharAt(n-1);
                }
            }else if(ch=='#'){
                String result=sb.toString();
                sb.append(result);
            }else if(ch=='%'){
                 sb.reverse();

            }
        }
         String str=sb.toString();
         return str.length()<=k ?'.':str.charAt((int)k);
    
    }
}