class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        char[] arr=s.toCharArray();
        for(int i=1;i<arr.length;i++){
            int a=(int)(arr[i-1]-'0');
            int b=(int)(arr[i]-'0');
            if(Math.abs(a-b)>2){
                return false;
            }
        }
        return true;
    }
}