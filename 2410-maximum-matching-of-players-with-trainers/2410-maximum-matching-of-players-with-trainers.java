class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p1 = 0, p2 = 0, count = 0, n = players.length, m = trainers.length;
        while(p1<n && p2<m){
            if(trainers[p2]<players[p1]){
                p2++;
            }
            else{
                count++;
                p1++;
                p2++;
            }
        }
        return count;
    }
}