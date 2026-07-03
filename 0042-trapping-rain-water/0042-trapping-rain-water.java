class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int total=0;
        int[] prefix=leftMax(height);
        int[] suffix=rightMax(height);
        for(int i=0;i<height.length;i++){
            if(height[i]<prefix[i] && height[i]<suffix[i]){
                total+=Math.min(prefix[i],suffix[i])-height[i];
            }
        }
        return total;
    }
        private int[] leftMax(int[] height){
            int n=height.length;
            int[] prefix=new int[n];
            prefix[0]=height[0];
            for(int i=1;i<n;i++){
                prefix[i]=Math.max(prefix[i-1],height[i]);
            }
            return prefix;
        }
        private int[] rightMax(int[] height){
            int n=height.length;
            int[] suffix=new int[n];
            suffix[n-1]=height[n-1];
            for(int i=n-2;i>=0;i--){
                suffix[i]=Math.max(suffix[i+1],height[i]);
            }
            return suffix;
        }
}