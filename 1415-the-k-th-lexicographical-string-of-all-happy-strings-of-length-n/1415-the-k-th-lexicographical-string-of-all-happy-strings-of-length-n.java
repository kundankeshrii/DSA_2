class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder curr=new StringBuilder();
        List<String>result=new ArrayList<>();
        solve(curr,result,n);
        if(result.size()<k){
            return "";
        }
        return result.get(k-1);
    }
    private void solve(StringBuilder curr,List<String>result,int n){
        if(curr.length()==n){
            result.add(curr.toString());
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if(curr.length()>0 && curr.charAt(curr.length()-1)==ch) continue;
            curr.append(ch);
            solve(curr,result,n);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}