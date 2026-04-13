class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        int result=0;
        if(n<2) return n;
        for(int i=0;i<n;i++){
            HashMap<String,Integer>mpp=new HashMap<>();
            int duplicates=0;
            int max=0;
            for(int j=i+1;j<n;j++){
                int x1=points[i][0],y1=points[i][1];
                int x2=points[j][0],y2=points[j][1];
                if(x1==x2 && y1==y2){
                    duplicates++;
                }

                int dx=x2-x1;
                int dy=y2-y1;
                int gcd=gcd(dx,dy);
                dx/=gcd;
                dy/=gcd;

                String key=dx+","+dy;
                mpp.put(key,mpp.getOrDefault(key,0)+1);
                max=Math.max(max,mpp.get(key));

                }
                result=Math.max(result,max+duplicates+1);
            }
            return result;
    }
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}