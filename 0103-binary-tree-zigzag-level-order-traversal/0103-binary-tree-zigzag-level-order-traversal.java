class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean reverse = false;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> li = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                if (reverse) {
                    li.add(0, curr.val);
                } else {
                    li.add(curr.val);
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            ans.add(li);
            reverse = !reverse;
        }

        return ans;
    }
}