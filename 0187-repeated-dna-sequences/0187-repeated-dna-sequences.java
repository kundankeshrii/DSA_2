class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String>list=new ArrayList<>();
        int l=0;
        int k=10;
        StringBuilder sb=new StringBuilder();
        Map<String,Integer>mpp=new HashMap<>();
        for(int r=0;r<s.length();r++){
            sb.append(s.charAt(r));
            if(r-l+1==k){
                mpp.put(sb.toString(),mpp.getOrDefault(sb.toString(),0)+1);
            }
            if(r-l+1>k){
                sb.deleteCharAt(0);
                mpp.put(sb.toString(),mpp.getOrDefault(sb.toString(),0)+1);
                l++;
            }
        }
        for(Map.Entry<String,Integer>e:mpp.entrySet()){
            if(e.getValue()>1){
                list.add(e.getKey());
            }
        }
        return list;
    }
}