class Solution {
    public String getHappyString(int n, int k) {
        int[] cnt={0};
        StringBuilder curr=new StringBuilder();
        String[] result={""};
        solve(curr,k,cnt,result,n);
        return result[0];
    }
    private void solve(StringBuilder curr,int k,int[] cnt,String[]result,int n){
        if(curr.length()==n){
             cnt[0]++;
             if(cnt[0]==k){
                result[0]=curr.toString();
             }
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if(curr.length()>0 && curr.charAt(curr.length()-1)==ch) continue;
            curr.append(ch);
            solve(curr,k,cnt,result,n);
            if(!result[0].isEmpty()) return;
            curr.deleteCharAt(curr.length()-1);
        }
    }
}