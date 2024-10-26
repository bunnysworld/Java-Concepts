package concepts.collection.priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyPriorityQueue<T> {

    List<T> heap;
    Comparator<T> comparator;

    public MyPriorityQueue(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);

    }

    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int idx) {
        int parentIdx = (idx - 1) / 2;
        while (idx > 0 && comparator.compare(heap.get(parentIdx), heap.get(idx)) > 0) {
            swap(idx, parentIdx);
            idx = parentIdx;
            parentIdx = (idx - 1) / 2;
        }
    }

    public T pop() {
        T element = heap.remove(0);
        heapifyDown(0);
        return element;
    }

    private void heapifyDown(int idx) {
        int leftIdx = 2 * idx + 1;
        int rightIdx = 2 * idx + 2;
        int minIdx = idx;
        if (leftIdx < heap.size() && comparator.compare(heap.get(minIdx), heap.get(leftIdx)) > 0) {
            minIdx = leftIdx;
        }
        if (rightIdx < heap.size() && comparator.compare(heap.get(minIdx), heap.get(rightIdx)) > 0) {
            minIdx = rightIdx;
        }
        if (minIdx != idx) {
            swap(idx, minIdx);
            heapifyDown(minIdx);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
