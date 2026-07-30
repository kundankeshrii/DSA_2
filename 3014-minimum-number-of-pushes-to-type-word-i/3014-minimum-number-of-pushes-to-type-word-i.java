class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n<=8) return n;
        if(n>0 && n<=16) return (8+2*(n-8));
        if(n>16 && n<=24) return (8+16+(3*(n-16)));
        if(n>24 && n<=26 ) return (8+16+24+(4*(n-24)));
        return 0;
    }
}