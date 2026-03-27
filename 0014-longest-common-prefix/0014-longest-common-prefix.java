class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n=strs.length;
        StringBuilder sb=new StringBuilder();
        int i=0,j=n-1;
        while(i<strs[0].length()){
            if(strs[0].charAt(i)==strs[j].charAt(i)){
                sb.append(strs[0].charAt(i));
            }else{
                break;
            }
            i++;
        }
        return sb.toString();

    }
}