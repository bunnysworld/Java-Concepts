package concepts.binarytree;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(1);
        node.right = new Node(6);
        node.left.left = new Node(0);
        node.left.right = new Node(2);
        node.left.right.right = new Node(3);

        node.right.left = new Node(5);
        node.right.right = new Node(7);
        node.right.right.right = new Node(8);

        inOrderTraversal(node);
        System.out.println(values);
    }
    static List<Integer> values = new ArrayList<>();

    private static void inOrderTraversal(Node node) {
        if (node == null){
            return;
        }
        inOrderTraversal(node.left);
        values.add(node.data);
        inOrderTraversal(node.right);
    }
}
