class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        HashMap<Character,Integer>mpp=new HashMap<>();
        mpp.put('I',1);mpp.put('V',5);
        mpp.put('X',10);mpp.put('L',50);
        mpp.put('C',100);mpp.put('D',500);
        mpp.put('M',1000);
        int total=0;
        for(int i=0;i<n-1;i++){//isme loop n-1 tak hi chal rha hai ,agar n tak chalaoge toh array out of bound ho jayega .isliye last wala character miss ho ja raha hai ,toh last me add karna na bhulna 
            int curr=mpp.get(s.charAt(i));
            int next=mpp.get(s.charAt(i+1));
            if(curr<next){
                total-=curr;
            }else{
                total+=curr;
            }
        }
        total+=mpp.get(s.charAt(n-1));
        return total;
    }
}