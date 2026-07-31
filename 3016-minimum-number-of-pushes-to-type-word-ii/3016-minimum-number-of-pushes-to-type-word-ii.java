class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        for(char c: word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        reverse(freq);
        int ans = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0)
                break;

            ans += freq[i] * ((i / 8) + 1);
        }
        return ans;
    }
    private void reverse(int[] arr){
        int n=arr.length;
        int i=0;
        int j=n-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}