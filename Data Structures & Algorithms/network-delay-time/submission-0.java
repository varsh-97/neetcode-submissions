class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       // dist[n+1] will have INF for all values except k which will be 0
       // offer k,0 to queue and get all the nodes reachable from k
       // update their dist and add it to queue
       // keep repeating until queue is empty and return the max val in dist 


       int[] dist = new int[n+1];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[k] = 0;
       List<List<int[]>> adj = new ArrayList<>();
       for(int i=0; i<=n; i++)
       {
            adj.add(new ArrayList<>());
       }

       for(int[] t : times)
       {
            int u = t[0];
            int v = t[1];
            int ti = t[2];

            adj.get(u).add(new int[]{v,ti});
       }

       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
       pq.offer(new int[]{k,0});

       while(!pq.isEmpty())
       {
            int[] curr = pq.poll(); // always gets the min dist first
            int curr_node = curr[0];
            int curr_dis = curr[1];

            for(int[] nei : adj.get(curr_node))
            {
                int nbr = nei[0];
                int d = nei[1];
                int nd = d + curr_dis;

                if(nd < dist[nbr])
                {
                    dist[nbr] = nd;
                    pq.offer(new int[]{nbr, nd});
                }
            }
       }

       int count = 0;
       for(int i=1; i<=n; i++)
       {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            count = Math.max(count, dist[i]);
       }
       return count;
    }
}
