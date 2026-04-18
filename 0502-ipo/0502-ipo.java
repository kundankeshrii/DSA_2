class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        PriorityQueue<int[]>minHeap=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));

    for(int i=0;i<n;i++){
        minHeap.add(new int[]{capital[i],profits[i]});
    }
    while(k-- >0){
        while(!minHeap.isEmpty() && minHeap.peek()[0]<=w){
            int[] project=minHeap.poll();
            maxHeap.add(project[1]);
        }
        if(maxHeap.isEmpty()) break;
        w+=maxHeap.poll();
    }
    return w;
    }
}