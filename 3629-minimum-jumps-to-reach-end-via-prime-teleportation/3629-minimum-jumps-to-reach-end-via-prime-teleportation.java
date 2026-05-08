class Solution {
    boolean isPrime[];
    public int minJumps(int[] nums) {
        int maxEle=0;
        int n=nums.length;
        HashMap<Integer,List<Integer>>mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
            maxEle=Math.max(maxEle,nums[i]);
        }
        buildSieve(maxEle);
        boolean visited[]=new boolean[n];
        Queue<Integer>q=new LinkedList<>();
        HashSet<Integer>set=new HashSet<>();
        q.offer(0);
        visited[0]=true;
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int i=q.poll();// now checking the condition as per question
                if(i==n-1) return steps;
                if(i-1>=0 && !visited[i-1]){
                    q.offer(i-1);
                    visited[i-1]=true;
                }
                if(i+1<n && !visited[i+1]){
                    q.offer(i+1);
                    visited[i+1]=true;
                }//skip if primeNumber or already seen in set
                if(!isPrime[nums[i]] || set.contains(nums[i])){
                    continue;
                }
                //visit all multiples 
                for(int multiple=nums[i];multiple<=maxEle;multiple+=nums[i]){
                    if(!mpp.containsKey(multiple)) continue;
                    for(int j:mpp.get(multiple)){
                        if(!visited[j]){
                            q.offer(j);
                            visited[j]=true;
                        }
                    }
                }
                set.add(nums[i]);
            }
            steps++;
        }
        return -1;
    }
    private void buildSieve(int maxEle){
        isPrime=new boolean[maxEle+1];
        Arrays.fill(isPrime,true);
        if(maxEle>=0) isPrime[0]=false;
        if(maxEle>=1) isPrime[1]=false;
        for(int i=2;i*i<=maxEle;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=maxEle;j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }

}