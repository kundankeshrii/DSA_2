class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] temp1=s1.toCharArray();
        Arrays.sort(temp1);
        s1=new String(temp1);
        int k=s1.length();
        int l=0;
        StringBuilder sb=new StringBuilder();
        for(int r=0;r<s2.length();r++){
            sb.append(s2.charAt(r));
            if(r-l+1==k){
                char arr1[]=sb.toString().toCharArray();
                Arrays.sort(arr1);
                if(new String(arr1).contains(s1)) return true;
            }if(r-l+1>k){
                sb.deleteCharAt(0);
                char arr1[]=sb.toString().toCharArray();
                Arrays.sort(arr1);
                if(new String(arr1).contains(s1)) return true;
                l++;
            }
        }
        return false;
    }
}