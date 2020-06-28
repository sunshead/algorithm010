class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        // interate until both p and q are found
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode curr = stack.pop();
            if (curr.left != null) {
                parents.put(curr.left, curr);
                stack.push(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr);
                stack.push(curr.right);
            }
        }

        // ancestors set for p
        Set<TreeNode> ancestors = new HashSet<>();

        // traverse all ancestors (upwards) for p using parent pointers
        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }

        // the first ancestor of q which appears in p's ancestor set is their LCA
        while (!ancestors.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }
}