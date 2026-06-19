class Solution {
    public double angleClock(int hour, int minutes) {
        double minangle = minutes * 6;
        double hangle =  30 * (hour%12) + 0.5 * minutes;
        double diff = Math.abs(hangle - minangle);
        return Math.min(diff, 360-diff);
    }
}