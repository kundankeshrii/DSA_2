class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>result=new ArrayList<>();
        backTrack(1,n,k,result,new ArrayList<>());
        return result;
    }
    private void backTrack(int start,int n, int k,List<List<Integer>>result,List<Integer>temp){
        if(temp.size()==k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=n;i++){
            temp.add(i);//choose 
            backTrack(i+1,n,k,result,temp);//explore
            temp.remove(temp.size()-1);//undo
        }
    }
}