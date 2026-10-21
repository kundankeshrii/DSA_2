class Solution {
    public int minOperations(String s) {
        int n=s.length();
        boolean flag=true;
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)>s.charAt(i)){
                flag=false;
                break;
            }
        }
        if(flag==true) return 0;
        if(n==2) return -1;

        char minChar=s.charAt(0);
        char maxChar=s.charAt(0);
        for(int i=1;i<n;i++){
            minChar=(char)Math.min(s.charAt(i),minChar);
            maxChar=(char)Math.max(s.charAt(i),maxChar);
        }
        if(s.charAt(0)==minChar || s.charAt(n-1)==maxChar){
            return 1;
        }

        int min_mid=s.charAt(1);
        int max_mid=s.charAt(1);
        for(int i=2;i<n-1;i++){
            min_mid=(char)Math.min(min_mid,s.charAt(i));
            max_mid=(char)Math.max(max_mid,s.charAt(i));
        }
        if(s.charAt(0)>max_mid && s.charAt(n-1)<min_mid){
            return 3;
        }
        return 2;
        
    }
}