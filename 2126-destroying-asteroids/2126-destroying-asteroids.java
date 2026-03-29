class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int i=0, n = asteroids.length;
        long lmass = mass;
        while(i<n && asteroids[i]<=mass){
            i++;
        }
        if(i>=n) return true;
        for(int j=0;j<i;j++){
            lmass+=asteroids[j];
        }
        while(i<n){
            if(lmass<asteroids[i]) return false;
            else lmass+=asteroids[i];
            i++;
        }
        return true;

    }
}