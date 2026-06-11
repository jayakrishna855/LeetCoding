class Solution {
    private static final int MOD = 1_000_000_007;
    private int qpow(int x, int y){
        long res = 1;
        long base = x;
        while(y>0){
            if((y&1) == 1){
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            y>>=1;
        }
        return (int) res;
    }
    private int dfs(List<List<Integer>> g, int x, int f){
        int maxd = 0;
        for(int v: g.get(x)){
            if(v == f) continue;
            maxd = Math.max(maxd, dfs(g, v, x)+1);
        }
        return maxd;
    }
    
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<=n;i++) g.add(new ArrayList<>());
        for(int[] edge: edges){
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        int maxDepth = dfs(g, 1, 0);
        return qpow(2, maxDepth-1);
    }
}