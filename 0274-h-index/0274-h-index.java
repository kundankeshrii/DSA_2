class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int hI=0;
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i<=citations[j]){
                    cnt++;
                }
            }
            if(cnt>=i){
                hI=i;
            }
        }
        return hI;
    }
}