class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int layers=Math.min(m/2,n/2);
        for(int layer=0;layer<layers;layer++){
            List<Integer>list=new ArrayList<>();
            int top=layer;
            int bottom=m-1-layer;
            int left=layer;
            int right=n-1-layer;
            //left to right
            for(int i=left;i<right;i++){
                list.add(grid[top][i]);
            }
            //top to bottom
            for(int i=top;i<bottom;i++){
                list.add(grid[i][right]);
            }
            //right to left
            for(int i=right;i>left;i--){
                list.add(grid[bottom][i]);
            }
            //bottom to top
            for(int i=bottom;i>top;i--){
                list.add(grid[i][left]);
            }
            int len=list.size();
            int newK=k%len;
            //rotate
             Collections.rotate(list,-newK);
             //fill up again
              //left to right
            int idx=0;
            for(int i=left;i<right;i++){
                grid[top][i]=list.get(idx++);
            }
            //top to bottom
            for(int i=top;i<bottom;i++){
                grid[i][right]=list.get(idx++);
            }
            //right to left
            for(int i=right;i>left;i--){
                grid[bottom][i]=list.get(idx++);
            }
            //bottom to top
            for(int i=bottom;i>top;i--){
                grid[i][left]=list.get(idx++);
            }
        }
        return grid;
    }
}