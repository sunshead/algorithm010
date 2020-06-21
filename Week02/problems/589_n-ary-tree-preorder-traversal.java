class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.add(curr.val);
            Collections.reverse(curr.children);
            for (Node c: curr.children) {
                if (c != null) {
                    stack.push(c);
                }
            }
        }
        return res;
    }
}