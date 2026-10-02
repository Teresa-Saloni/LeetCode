class Solution {
    Integer prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }

        prev = root.val;

        inorder(root.right);
    }
}