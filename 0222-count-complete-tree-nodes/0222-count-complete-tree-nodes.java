class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // Perfect binary tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        // Otherwise count normally using recursion
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;

        while (node != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;

        while (node != null) {
            height++;
            node = node.right;
        }

        return height;
    }
}