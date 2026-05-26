class Solution {
    int[] size, parent;

    public int find(int u) {
        if (u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return;
        if (size[pu] >= size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(size, 1);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && isConnected[i][j] == 1)
                    union(i, j);

        int ans = 0;
        for (int i = 0; i < n; i++)
            if (parent[i] == i) ans++;
        return ans;
    }
}