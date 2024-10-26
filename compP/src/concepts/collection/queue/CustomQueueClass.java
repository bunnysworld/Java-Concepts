package concepts.collection.queue;

public class CustomQueueClass<T> {
    public class Node<T> {

        T val;

        Node<T> next;

        public Node(T val) {
            this.val = val;
            next = null;
        }
    }

    private Node<T> front;

    private Node<T> rear;

    public CustomQueueClass() {
        front = null;
        rear = null;
    }

    public void add(T val) {
        Node<T> node = new Node<>(val);
        if (rear == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public T poll() {
        if (front == null) {
            return null;
        }
        T tmp = front.val;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return tmp;
    }

    public T peek() {
        if (front == null) {
            return null;
        }
        return front.val;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
