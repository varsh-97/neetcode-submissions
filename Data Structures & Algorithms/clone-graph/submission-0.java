/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // create duplicate nodes for all OG nodes
        // add them to the map
        // iterate over it's neighbors and dfs()

        if(node == null) return null; // base case

        if(map.containsKey(node)) return map.get(node); // check map for duplicates

        // create a new node
        Node clone = new Node(node.val);
        map.put(node, clone); // add the unique val to map

        // iterate over it's neighbors and add that to clone
        for(Node n : node.neighbors)
        {
            clone.neighbors.add(cloneGraph(n));
        }

        return clone;
    }
}