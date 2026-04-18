class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=capital.length;
        int[][] project=new int[n][2];
        for(int i=0;i<n;i++){
            project[i][0]=capital[i];
            project[i][1]=profits[i];
        }
        Arrays.sort(project,(x,y)->Integer.compare(x[0],y[0]));
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(k-- >0){
            while(i<n && project[i][0]<=w ){
                maxHeap.add(project[i][1]);
                i++;
            }
            if(maxHeap.isEmpty()) break;
            w+=maxHeap.poll();
        }
        return w;
    }
}