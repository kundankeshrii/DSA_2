class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String>ans=new ArrayList<>();
        for(int hh=0;hh<=11;hh++){
            for(int mm=0;mm<=59;mm++){
                if(Integer.bitCount(hh)+Integer.bitCount(mm)==turnedOn){
                    String h=Integer.toString(hh);
                    String m=(mm<10?"0":"")+mm;
                    ans.add(h+":"+m);
                }
            }
        }
        return ans;
    }
}