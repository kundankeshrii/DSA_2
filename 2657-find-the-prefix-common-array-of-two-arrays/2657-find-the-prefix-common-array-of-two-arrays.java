class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        HashSet<Integer> set=new HashSet<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            set.add(A[i]);
            List<Integer>temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(set.contains(B[j])){
                    temp.add(B[j]);
                }
            }
            arr[i]=temp.size();
        }
        return arr;
    }
}