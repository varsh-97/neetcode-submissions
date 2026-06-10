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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // BFS with a twist. 
        // add right child first at each level and append only the first val polled at each level
        // TC: O(n), SC: O(1)

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) return new ArrayList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                TreeNode curr = queue.poll();
                if(i==0) result.add(curr.val); // only append 1st poll()

                if(curr.right != null) queue.offer(curr.right);
                if(curr.left != null) queue.offer(curr.left);
            }
        }
        return result;
    }
}
