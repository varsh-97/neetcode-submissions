class Solution {
    class UnionFind
    {
        int[] parent;
        int[] rank;

        public UnionFind(int n)
        {
            parent = new int[n+1];
            rank = new int[n+1];

            for(int i=1; i<=n; i++)
            {
                parent[i] = i;
            }
        }

        public int find(int x)
        {
            if(x != parent[x])
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y)
        {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return false;

            if(rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else if(rank[rootY] > rank[rootX]) parent[rootX] = rootY;
            else
            {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        // union-find
        // at every union, if we find a cycle, update result with that edge
        // keep doing this until we iterate over all the edges
        int[] result = new int[2];
        int n = edges.length;

        UnionFind uf = new UnionFind(n);

        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];

            if(!uf.union(u,v)) result = e;
        }
        return result;
    }
}
