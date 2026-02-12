class Solution {
    public boolean canFinish(int[] piles, int k, int h){
        long hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) hours++;
        }
        return hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high;
        while(low<high){
            int mid = (low+high)/2;
            if(canFinish(piles,mid,h)){
                ans = mid;
                high = mid;
            }
            else low= mid + 1;
        }
        return ans;
    }
}