class Solution {
    public int trap(int[] height) {
       int twater = 0, leftMax = 0, rightMax = 0;
       int start =0, end = height.length-1;
       while(start<end){
        leftMax = Math.max(leftMax, height[start]);
        rightMax = Math.max(rightMax, height[end]);
        if(leftMax<rightMax){
            twater+= leftMax-height[start];
            start++;
        }
        else{
            twater+= rightMax - height[end];
            end--;
        }
       }
       return twater;
    }
}