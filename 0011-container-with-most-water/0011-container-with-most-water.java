class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         max = Math.max(max, (j-i)*Math.min(height[i],height[j]));
        //     }
        // }
        int i=0, j = n-1;
        while(i<j){
            max = Math.max(max, (j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return max;
    }
}