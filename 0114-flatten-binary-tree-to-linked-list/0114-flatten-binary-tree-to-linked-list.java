class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {

                TreeNode temp = curr.left;

                // Find rightmost node of left subtree
                while (temp.right != null) {
                    temp = temp.right;
                }

                // Attach original right subtree
                temp.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
}