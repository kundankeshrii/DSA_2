class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer>mpp=new HashMap<>();
        for(char c:s.toCharArray()){
            mpp.put(c,mpp.getOrDefault(c,0)+1);
        }
        List<Character>ans=new ArrayList<>(mpp.keySet());
        Collections.sort(ans,(a,b)->mpp.get(b)-mpp.get(a));
        StringBuilder sb=new StringBuilder();
        for(char c:ans){
            sb.append(String.valueOf(c).repeat(mpp.get(c)));
        }
        return sb.toString();
    }
}