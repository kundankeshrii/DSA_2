class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0,j=n-1;
        int max=Integer.MIN_VALUE;
        while(i<j){
            if(height[i]<height[j]){
            int width=j-i;
            int area=Math.min(height[i],height[j])*width;
            max=Math.max(max,area);
            i++;
            }else{
                int width=j-i;
                int area=Math.min(height[i],height[j])*width;
                max=Math.max(max,area);
                j--;
            }
            
        }
        return max;
    }
}