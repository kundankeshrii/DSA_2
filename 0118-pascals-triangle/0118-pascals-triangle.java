class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            result.add(fun(i));
        }
        return result;
    }
    private List<Integer>fun(int row){
        List<Integer>list=new ArrayList<>();
        long ans=1;
        list.add(1);
        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans/=col;
            list.add((int)(ans));
        }
        return list;
    }
}