class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        if(n<k) return false;
        HashSet<String> set = new HashSet<>();
        for(int i=k;i<=n;i++) {
            String sub=s.substring(i-k,i);
            if(!set.contains(sub)){
             set.add(sub);
            }
        }
        return set.size()==1<<k;
    }
}