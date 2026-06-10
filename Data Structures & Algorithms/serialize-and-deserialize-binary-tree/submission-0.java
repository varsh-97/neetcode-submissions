/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    // use BFS for level-order traversal
    // if node is null, append 'null' and skip to next node. Else, attach node.val and add it's children
    // TC: O(n), SC: O(n)

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return "";
        queue.offer(root);

        while(!queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            if(curr == null) // if node is null
            {
                sb.append("null,");
                continue;
            }
            
            sb.append(curr.val).append(","); // not null, attach val
            // offer children to queue
            queue.offer(curr.left);
            queue.offer(curr.right);  
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;

        String[] nodes = data.split(","); // convert to string[]
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0])); // form root node
        Queue<TreeNode> queue = new LinkedList<>(); // add root to queue
        queue.offer(root);
        int i = 1; // i++

        while(!queue.isEmpty() && i < nodes.length) 
        {
            TreeNode parent = queue.poll(); // for each parent , build it's children

            // left child
            if(!nodes[i].equals("null"))
            {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.left);
            }
            i++;

            // right child
            if(i < nodes.length && !nodes[i].equals("null"))
            {
                parent.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.right);
            }
            i++;
        }

        return root;
    }
}
