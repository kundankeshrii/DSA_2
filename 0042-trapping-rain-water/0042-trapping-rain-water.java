class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] prefix=leftMax(height);
        int[] suffix=rightMax(height);
        int total=0;
        for(int i=0;i<n;i++){
            if(height[i]<prefix[i] && height[i]<suffix[i]){
                total+=Math.min(prefix[i],suffix[i])-height[i];
            }
        }
        return total;

    }
    private int[] rightMax(int[] height){
        int n=height.length;
        int[] suffix=new int[n];
        int suff=0;
        for(int i=n-1;i>=0;i--){
            suffix[i]=Math.max(suff,height[i]);
            suff=suffix[i];
        }
        return suffix;
    }
    private int[] leftMax(int[] height){
        int n=height.length;
        int[] prefix=new int[n];
        int pref=0;
        for(int i=0;i<n;i++){
            prefix[i]=Math.max(pref,height[i]);
            pref=prefix[i];
        }
        return prefix;
    }
}