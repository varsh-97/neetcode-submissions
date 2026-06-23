class PrefixTree {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;
    }
    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode(); 
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray())
        {
            int idx = c - 'a';
            if(node.children[idx] == null)
            {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node!=null && node.end;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node!=null;
    }

    public TrieNode find(String word)
    {
        TrieNode node = root;
        for(char c : word.toCharArray())
        {
            int idx = c - 'a';
            if(node.children[idx] == null)
            {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }
}
