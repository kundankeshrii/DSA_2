class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long totalSum=(long)n*(n+1)/2;
        if(Math.abs(target)>totalSum) return new int[0];
        long diff=totalSum-target;
        if(diff%2==1) return new int[0];
        long need=diff/2;
        boolean []negative=new boolean[n+1];
        for(int x=n;x>0;x--){
            if(x<=need){
                need-=x;
                negative[x]=true;
            }
        }
        if(need!=0) return new int[0];
        List<Integer>list=new ArrayList<>();
        for(int x=1;x<=n;x++){
            if(negative[x]){
                list.add(-x);
            }else{
                list.add(x);
            }
        }
        Collections.sort(list);
         int[] arr=new int[list.size()];
         for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
         }
         return arr;

    }
}