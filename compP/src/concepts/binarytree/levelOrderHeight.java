package concepts.binarytree;

public class levelOrderHeight {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        printLevelOrder(root);
    }

    static void printLevelOrder(Node node) {
        int h = height(node); // 0n
        for (int i = 1; i <= h; i++) { // 0n^2
            printCurrentLevel(node, i);
            System.out.print(System.lineSeparator());
        }
    }

    static int height(Node node) {
        if (node == null)
            return 0;
        else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);
            if (lHeight > rHeight) {
                return lHeight + 1;
            } else {
                return rHeight + 1;
            }
        }
    }

    static void printCurrentLevel(Node node, int level) {
        if (node == null) {
            return;
        } else if (level == 1) {
            System.out.print(node.data + " ");
        } else if (level > 1) {
             printCurrentLevel(node.left, level - 1);
             printCurrentLevel(node.right, level - 1);
        }
    }
}
