class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] kpoints = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            int d = x * x + y * y; 
            pq.offer(new int[]{d, i});
        }

        for (int i = 0; i < k; i++) {
            kpoints[i] = points[pq.poll()[1]];
        }

        return kpoints;
    }
}