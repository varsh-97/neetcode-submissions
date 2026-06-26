class Solution {
    Map<String, PriorityQueue<String>> map;
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // we need to use all the tickets that are leaving an airport before we add that airport to our itenary
        // use hierholzer's algorithm
        // construct a map such that for each from:minHeap(dest) to get the lex smaller dest
        // dfs() from each dest until we are left with no more outgoing edges
        // then keep adding those destinations in reverse to the result
        // TC: O(E log E), SC: O(E)

        map = new HashMap<>();
        

        for(List<String> t : tickets)
        {
            String from = t.get(0);
            String to = t.get(1);

            map.computeIfAbsent(from, k->new PriorityQueue<>())
                 .offer(to);            
        }

        dfs("JFK");
        return result;
    }

    public void dfs(String airport)
    {
        PriorityQueue<String> dest = map.get(airport); // get the destinations list

        while(dest != null && !dest.isEmpty()) // we cannot poll if there are no outgoing edges
        {
            String curr = dest.poll(); // get the lex smaller airport first
            dfs(curr); // post-order traversal
        }

        result.addFirst(airport); // add in reverse
    }
}