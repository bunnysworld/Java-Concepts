package cp.ltDaily;

import java.util.HashMap;
import java.util.Map;

public class HeightOfBinaryTreeAfterRemoval {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node6 = new TreeNode(6, null, null);

        TreeNode node2 = new TreeNode(2, node4, node6);
        TreeNode node1 = new TreeNode(1, null, null);

        TreeNode node8 = new TreeNode(8, node2, node1);

        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node9 = new TreeNode(9, node3, node7);

        TreeNode root = new TreeNode(5, node8, node9);
        int[] q = {3, 2, 4, 8};
        System.out.println(treeQueries(root, q));

    }

    public static int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        Map<TreeNode, Integer> heightCache = new HashMap<>();

        // Run DFS to fill resultMap with maximum heights after each query
        dfs(root, 0, 0, resultMap, heightCache);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = resultMap.get(queries[i]);
        }
        return result;
    }

    // Function to calculate the height of the tree
    private static int height(TreeNode node, Map<TreeNode, Integer> heightCache) {
        if (node == null) {
            return -1;
        }

        // Return cached height if already calculated
        if (heightCache.containsKey(node)) {
            return heightCache.get(node);
        }

        int h = 1 + Math.max(
                height(node.left, heightCache),
                height(node.right, heightCache)
        );
        heightCache.put(node, h);
        return h;
    }

    // DFS to precompute the maximum values after removing the subtree
    private static void dfs(
            TreeNode node,
            int depth,
            int maxVal,
            Map<Integer, Integer> resultMap,
            Map<TreeNode, Integer> heightCache
    ) {
        if (node == null) {
            return;
        }

        resultMap.put(node.val, maxVal);

        // Traverse left and right subtrees while updating max values
        dfs(
                node.left,
                depth + 1,
                Math.max(maxVal, depth + 1 + height(node.right, heightCache)),
                resultMap,
                heightCache
        );
        dfs(
                node.right,
                depth + 1,
                Math.max(maxVal, depth + 1 + height(node.left, heightCache)),
                resultMap,
                heightCache
        );
    }
}
