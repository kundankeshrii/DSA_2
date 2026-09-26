class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }else{
                int curr=Math.abs(asteroids[i]);
                while(!st.isEmpty() && st.peek()>0){
                    if(curr==st.peek()){
                        st.pop();
                        curr=0;
                        break;
                    }
                    else if(curr<st.peek()){
                        curr=0;
                        break;
                    }else{
                        st.pop();
                    }
                }
                if(curr>0){
                st.push(-curr);
                }    
            }
        }
        int[] arr=new int[st.size()];
        for(int i=0;i<st.size();i++){
            arr[i]=st.get(i);
        }
        return arr;
    }
}