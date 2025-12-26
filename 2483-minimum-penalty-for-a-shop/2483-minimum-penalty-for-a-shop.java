class Solution {
    public int bestClosingTime(String customers) {
         int penalty=0;
         int idx=0;
         for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='Y'){
                penalty++;
            }
         }
         int minPenalty=penalty;
         for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='Y'){
                penalty--;
            }else{
                penalty++;
            }
         if(minPenalty>penalty){
            minPenalty=penalty;
            idx=i+1;
         }
     }
         return idx;
    }
}