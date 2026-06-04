class Solution {
    public int totalWaviness(int num1, int num2) {
        int cnt=0;
        for(int i=num1;i<=num2;i++){
            int digit=(int)(Math.log10(i)+1);
            if(digit>2){
            List<Integer>arr=new ArrayList<>();
            int n=i;
            while(n>0){
                int r=n%10;
                arr.add(r);
                n/=10;
            }
            Collections.reverse(arr);
            for(int j=1;j<arr.size()-1;j++){
                if(arr.get(j-1)<arr.get(j) && arr.get(j)>arr.get(j+1)){
                    cnt++;
                }if(arr.get(j-1)>arr.get(j) && arr.get(j)<arr.get(j+1)){
                    cnt++;
                }
            }

            }
        }
        return cnt;
    }
}