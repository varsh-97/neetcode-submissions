class Solution {
    class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int n)
        {
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
        }

        public int find(int x)
        {
            if(parent[x] != x)
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y)
        {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) return false; // already connected

            if(rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else if(rank[rootY] > rank[rootX]) parent[rootX] = rootY;
            else
            {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // union-disjoint set and union all the edges
        // iterate over the parent[] and if there are more than 1 unique val, return false
        // TC: O(E), SC: O(n)

        
        UnionFind uf = new UnionFind(n);
        if(edges.length != n-1) return false; // fully connected graph has n-1 edges
        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];

            if(!uf.union(u,v)) return false; // there is a cycle
        }
        return true;
    }
}
