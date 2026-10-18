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
    private int[]preorder;
    private HashMap<Integer, Integer> inorder_index;
    public TreeNode build(int root_index, int low, int high){
        if(low > high) return null;
        TreeNode root = new TreeNode(preorder[root_index]);
        int root_inorder_index = inorder_index.get(root.val);
        int leftSize = root_inorder_index-low;

        root.left = build(root_index + 1, low, root_inorder_index-1);
        root.right = build(root_index + leftSize+1, root_inorder_index + 1, high);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inorder_index = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            inorder_index.put(inorder[i], i);
        }
        return build(0, 0, inorder.length-1);
    }
}
