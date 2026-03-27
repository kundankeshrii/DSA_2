class Solution {
    public int lengthOfLastWord(String s) {
        String[] str=s.split(" ");
        int n=str.length;
        String last=str[n-1].trim();
        return last.length();
    }
}