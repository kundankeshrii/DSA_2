class Solution {
    public boolean isMatch(String s, String p) {
        String temp=s;
        s=p;
        p=temp;

        int n=s.length();
        int m=p.length();
        boolean[]prev=new boolean[m+1];
        prev[0]=true;
        for(int j=1;j<=m;j++) prev[j]=false;

    for(int i=1;i<=n;i++){
        boolean flag=true;
            boolean[]curr=new boolean[m+1];
            for(int k=1;k<=i;k++){
                if(s.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }
            }
            curr[0]=flag;
        for(int j=1;j<=m;j++){
            if(s.charAt(i-1)==p.charAt(j-1) || s.charAt(i-1)=='?'){
                curr[j]=prev[j-1]; 
            }else if(s.charAt(i-1)=='*'){
                curr[j]= prev[j]  || curr[j-1];
            }else{
                curr[j]=false;
            }
        }
        prev=curr;
    }        
    return prev[m];
    }
}