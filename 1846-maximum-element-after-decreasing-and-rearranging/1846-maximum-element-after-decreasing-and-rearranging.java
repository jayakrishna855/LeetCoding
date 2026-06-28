class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 1;
        int prev = arr[0];
        if(prev>1) prev = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == prev || arr[i] == prev+1){
                max = Math.max(arr[i], max);
                prev = max;
            }
            else{
                prev = prev+1;
                max = Math.max(prev, max);
            }
        }
        return max;
    }
}