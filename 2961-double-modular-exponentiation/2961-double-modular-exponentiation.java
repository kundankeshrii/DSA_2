class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer>list=new ArrayList<>();
        int n=variables.length;
         
        for(int i=0;i<n;i++){
                int a=variables[i][0];
                int b=variables[i][1];
                int c=variables[i][2];
                int m=variables[i][3];
                int x= modPow(a,b,10);
                int y=modPow(x,c,m);
                if(y==target){
                    list.add(i);
                }
                 
        }
        return list;
    }
    private int modPow(int a,int b,int mod){
        if(b==0) return -1;
        int half=modPow(a,b/2,mod);
        int result=(half*half)%mod;
         if(b%2==1){
            result=(result*a)%mod;
         }
        return result;
    }
}