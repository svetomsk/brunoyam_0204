public class TreeExample {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        String value;

        public TreeNode(TreeNode left, TreeNode right, String value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public static void walk(TreeNode node) {
        System.out.println("Entering " + node.value);
        System.out.println(node.value);
        if(node.left != null) {
            walk(node.left);
            System.out.println("Back to " + node.value);
        }
        if(node.right != null) {
            walk(node.right);
            System.out.println("Back to " + node.value);
        }
        System.out.println("Quiting " + node.value);
    }

    public static void main(String[] args) {
        // 3 level
        TreeNode three = new TreeNode(null, null, "3");
        TreeNode four = new TreeNode(null, null, "4");
        TreeNode five = new TreeNode(null, null, "5");
        TreeNode two = new TreeNode(null, null, "2");

        // 2 level
        TreeNode mul = new TreeNode(three, four, "*");
        TreeNode del = new TreeNode(five, two, "/");

        // 1 level
        TreeNode plus = new TreeNode(mul, del, "+");

        walk(mul);
    }
}
