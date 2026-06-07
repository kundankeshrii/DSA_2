// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         char[] temp1=s1.toCharArray();
//         Arrays.sort(temp1);
//         s1=new String(temp1);
//         int k=s1.length();
//         for(int r=0;r+k<=s2.length();r++){
//              String subStr=s2.substring(r,r+k);
//              char[] arr1=subStr.toCharArray();
//              Arrays.sort(arr1);
//             subStr=new String(arr1);
//             if(s1.equals(subStr)) return true;
//         }
//         return false;
//     }
// }
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1A=new int[26];
        for(char c:s1.toCharArray()){
            s1A[c-'a']++;
        }
        int k=s1.length();
        for(int i=0;i+k<=s2.length();i++){
            int[] temp=new int[26];
            for(int j=i;j<i+k;j++){
                temp[s2.charAt(j)-'a']++;
            }
            if(Arrays.equals(temp,s1A)) return true;  //comparing two arrays if their element are same in order 
        }
        return false;
    }
}