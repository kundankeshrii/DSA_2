class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        String s=""+n;
        String x="";
        long sum=0;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            int num=ch-'0';
            if(num!=0){
                x+=ch;
                sum+=num;
            }
        }
        long numA=Long.parseLong(x);
        return numA*sum;
    }
}