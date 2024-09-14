//package cp.easy.bst;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class IncreasingOrderBst {
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//
//        root.left.left.left = new TreeNode(1);
//
//        root.right.right = new TreeNode(8);
//        root.right.right.left = new TreeNode(7);
//        root.right.right.right = new TreeNode(9);
//
//        increasingBST(root);
//
//    }
//
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//    static List<Integer> li = new ArrayList<>();
//
//    public static TreeNode increasingBST(TreeNode root) {
//        return increasingBST(root, null);
//    }
//
//    private static TreeNode increasingBST(TreeNode root, TreeNode tail) {
//        if (root == null)
//            return tail;
//
//        TreeNode ans = increasingBST(root.left, root);
//        root.left = null;
//        root.right = increasingBST(root.right, tail);
//        return ans;
//    }
//
//    public static TreeNode increasingBST_1(TreeNode root) {
//        traversal(root);
//        TreeNode node = new TreeNode(li.get(0));
//        TreeNode ans = node;
//        li.remove(0);
//        for (int i : li){
//            node.right = new TreeNode(i);
//            node = node.right;
//        }
//        return ans;
//    }
//
//    public static void traversal(TreeNode root){
//        if (root == null)
//            return;
//        traversal(root.left);
//        li.add(root.val);
//        traversal(root.right);
//    }
//
//}
