package cp.easy.bst;

public class InvertBt {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 4;
        node.left = new TreeNode(2);
        node.right = new TreeNode(7);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);

        invertTree(node);

    }

    public static TreeNode invertTree(TreeNode root) {
        if( root.left == null && root.right == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
