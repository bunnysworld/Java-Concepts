package cp.easy.bst;

import java.util.*;

public class AverageOfLevels {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2147483647);
        node.left = new TreeNode(2147483647);
        node.right = new TreeNode(2147483647);
        averageOfLevels(node);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<Double> ans = new ArrayList();
        double sum;
        double count;
        while (!queue.isEmpty()) {
            sum = 0;
            count = 0;
            Queue<TreeNode> tmp = new LinkedList();
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                sum += n.val;
                count++;
                if (n.left != null)
                    tmp.add(n.left);
                if (n.right != null)
                    tmp.add(n.right);
            }
            queue = tmp;
            ans.add(sum / count);
        }
        return ans;

    }
}
