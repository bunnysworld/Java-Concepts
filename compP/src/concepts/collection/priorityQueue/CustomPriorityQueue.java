package concepts.collection.priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomPriorityQueue<T> {

    List<T> heap;

    Comparator<T> comparator;

    public CustomPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>();
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
        if (heap.size() == 0) {
            return null;
        }
        T elem = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return elem;
    }

    private void heapifyDown(int idx) {
        int leftIdx = idx * 2 + 1;
        int rightIdx = idx * 2 + 2;
        int minIdx = idx;
        if (leftIdx < heap.size() && comparator.compare(heap.get(minIdx), heap.get(leftIdx)) > 0) {
            minIdx = leftIdx;
        }
        if (rightIdx < heap.size() && comparator.compare(heap.get(minIdx), heap.get(rightIdx)) > 0) {
            minIdx = rightIdx;
        }
        if (minIdx != idx) {
            swap(minIdx, idx);
            heapifyDown(minIdx);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

}
