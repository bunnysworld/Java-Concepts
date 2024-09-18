package concepts.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderUsingQueue {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        printLevelOrder(root);
    }

    static void printLevelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            if (curr != null){
                System.out.print(" "+curr.data);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
                queue.add(null);
            }else {
                System.out.print(" -> ");
            }
        }
    }
}
