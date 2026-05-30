class Solution {
   static class SegTree {
        int[] tree;
        int n;

        SegTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) update(2*node, start, mid, idx, val);
            else            update(2*node+1, mid+1, end, idx, val);
            tree[node] = Math.max(tree[2*node], tree[2*node+1]);
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return Math.max(query(2*node, start, mid, l, r),
                            query(2*node+1, mid+1, end, l, r));
        }

        void update(int idx, int val) { update(1, 0, n-1, idx, val); }
        int query(int l, int r)       { return query(1, 0, n-1, l, r); }
    }
    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        //List<Integer> blocks = new ArrayList<>();

        //Approach 1
        // TreeSet<Integer> blocks = new TreeSet<>();
        // for(int[] query: queries){
        //     if(query[0] == 1){
        //         blocks.add(query[1]);
        //     }
        //     else{
        //         int prev = 0, maxGap = 0;
                   //can use blocks.headSet(x, true) to traverse till element<=x
        //         for(Integer block: blocks){
        //             if(block>query[1]) break;
        //             maxGap = Math.max(maxGap, block-prev);
        //             prev = block;
        //         }
        //         maxGap = Math.max(maxGap, query[1]-prev);
        //         ans.add(maxGap>=query[2]);
        //     }
        // }


        //Approach 2
        // TreeSet<Integer> blocks = new TreeSet<>();
        // blocks.add(0);
        // TreeMap<Integer,Integer> maxGap = new TreeMap<>();
        // maxGap.put(0,0);
        // for(int[] query: queries){
        //     int x = query[1];
        //     if(query[0] == 1){
        //         int left = blocks.floor(x);
        //         int prevMax = maxGap.floorEntry(x).getValue();
        //         maxGap.put(x, Math.max(prevMax, x-left));
        //         blocks.add(x);

        //         Integer right = blocks.ceiling(x + 1);
               
        //         if (right != null) {
        //             int prevMaxBeforeRight = maxGap.floorEntry(right - 1).getValue();
        //             maxGap.put(right, Math.max(prevMaxBeforeRight, right - x));
        //         }
        //     }
        //     else{
        //         int size = query[2];
        //         int left = blocks.floor(x);

        //         int prevMax = maxGap.floorEntry(x).getValue();
        //         int lastGap = x -left;
        //         ans.add(Math.max(prevMax, lastGap)>=size);
        //     }
        // }

TreeSet<Integer> posSet = new TreeSet<>();
        posSet.add(0);
        for (int[] q : queries)
            if (q[0] == 1) posSet.add(q[1]);

        int m = posSet.size();
        int[] pos = new int[m];
        int i = 0;
        for (int p : posSet) pos[i++] = p;
        Map<Integer, Integer> compress = new HashMap<>();
        for (int j = 0; j < m; j++) compress.put(pos[j], j);

        SegTree seg = new SegTree(m);
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        seg.update(compress.get(0), 0);

       

        for (int[] query : queries) {
            int x = query[1];
            if (query[0] == 1) {
                int left = obstacles.floor(x);
                int cidx = compress.get(x);
                seg.update(cidx, x - left);

                Integer right = obstacles.ceiling(x + 1);
                if (right != null) {
                    int rcidx = compress.get(right);
                    seg.update(rcidx, right - x);
                }
                obstacles.add(x);

            } else {
                int sz = query[2];
                int left = obstacles.floor(x);
                int lcidx = compress.get(left);
                int maxG = seg.query(0, lcidx);
                maxG = Math.max(maxG, x - left);
                ans.add(maxG >= sz);
            }
        }

        

        return ans;
    }
}