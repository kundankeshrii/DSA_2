class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            set1.add(A[i]);
            set2.add(B[i]);
            List<Integer>temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(set1.contains(B[j])){
                    temp.add(B[j]);
                }
            }
            arr[i]=temp.size();
        }
        return arr;
    }
}