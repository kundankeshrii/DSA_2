class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int k=p.length();
        int[] freq=new int[26];
        for(char c:p.toCharArray()){
            freq[c-'a']++;
        }
        int i=0,j=0;
        List<Integer>list=new ArrayList<>();
        while(j<s.length()){
            freq[s.charAt(j)-'a']--;
            if(j-i+1==k){
                if(allZero(freq)){
                    list.add(i);
                }
                freq[s.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return list;
    }
    private boolean allZero(int[]arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0) return false;
        }
        return true;
    }
}