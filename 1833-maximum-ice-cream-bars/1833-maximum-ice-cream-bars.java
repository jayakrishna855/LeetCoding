class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i=0,n=costs.length;
        while(i<n){
            if(coins-costs[i]>=0){
                coins-=costs[i];
            }
            else{
                break;
            }
            i++;
        }
        return i;
    }
}