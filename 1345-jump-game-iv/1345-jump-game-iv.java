class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n==1) return 0;
        HashMap<Integer,List<Integer>>mpp=new HashMap<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            mpp.putIfAbsent(arr[i],new ArrayList<>());
            mpp.get(arr[i]).add(i);
        }
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        visited[0]=true;
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr=q.poll();
                if(curr==n-1) return steps;
                int left=curr-1;
                int right=curr+1;
                if(left>=0 && !visited[left]){
                    q.offer(left);
                    visited[left]=true;
                }
                if(right<n && !visited[right]){
                    q.offer(right);
                    visited[right]=true;
                }if(mpp.containsKey(arr[curr])){
                    for(int idx:mpp.get(arr[curr])){
                        if(!visited[idx]){
                            q.offer(idx);
                            visited[idx]=true;
                        }
                    }
                }
                mpp.remove(arr[curr]);
            }
            steps++;
        }
        return -1;
    }
}