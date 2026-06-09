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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // BFS

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);

        while(!queue.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            result.add(temp);
        }
        return result;
    }
}
