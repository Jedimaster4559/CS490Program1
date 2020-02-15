package program1;

import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>> {
    private ArrayList<E> heap;
    private static Object lock = new Object();

    /**
     *Constructor
     */
    public MinHeap() {
        heap = new ArrayList<E>();
    }

    /**
     * Returns the minimum element and removes it from the queue
     * @return the minimum element or null if the queue is empty
     */
    public E extract() {
        if (heap.size() <= 0) {
            return null;
        }

        else {
            synchronized (lock) {
                E min = heap.get(0);
                heap.set(0, heap.get(heap.size()-1));
                heap.remove(heap.size()-1);
                heapify(heap, 0);
                return min;
            }
        }
    }

    /**
     * Inserts an element into the priority queue
     * @param element is the inserted element
     */
    public void insert(E element) {
        synchronized (lock) {
            heap.add(element);
            int location = heap.size()-1;

            while (location > 0 && heap.get(location).compareTo(heap.get(parent(location))) < 0) {
                swap(heap, location, parent(location));
                location = parent(location);
            }
        }
    }

    /**
     * Checks to see if the priority queue is empty
     * @return true if the priority queue is empty or false if the priority queue is not empty
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /**
     * Gets the current size of the heap
     * @return the number of elements currently in the heap
     */
    public int size() {
        return heap.size();
    }

    /**
     * Gets the minimum element in the priority queue
     * Does not remove the element from the priority queue
     * @return the minimum element in the priority queue or null if the priority queue is empty
     */
    public E minimum() {
        if (heap.size() <= 0) {
            return null;
        }
        else {
            return heap.get(0);
        }
    }

    /**
     *Reheapifies the priority queue
     * @param list is the ArrayList to sort
     * @param i is the spot in the priority queue needing to be fixed
     */
    private static <E extends Comparable<E>> void heapify(ArrayList<E> list, int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int small; // The smallest element in the priority queue

        if (left <= list.size() - 1 && list.get(left).compareTo(list.get(i)) < 0) {
            small = left;
        }
        else {
            small = i;
        }

        if (right <= list.size()-1 && list.get(right).compareTo(list.get(small)) < 0) {
            small = right;
        }

        if (small != i) {
            swap(list, i, small);
            heapify(list, small);
        }
    }

    /**
     * Swaps two locations, i and j, in the ArrayList list
     * @param list is the ArrayList
     * @param i is the first position to be swapped
     * @param j is the second position  swapped
     */
    private static <E> void swap(ArrayList<E> list, int i, int j) {
        E t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }

    /**
     * Returns the index of the left child of node i
     * @param i is the index of the parent node
     * @return the index of the left child of node i
     */
    private static int leftChild(int i) {
        return 2*i + 1;
    }

    /**
     * Returns the index of the right child of node i
     * @param i is the index of the parent node
     * @return the index of the right child of node i
     */
    private static int rightChild(int i) {
        return 2*i + 2;
    }

    /**
     * Returns the index of the parent of node i
     * @param i is the index of the child node
     * @return the index of the parent of node i
     */
    private static int parent(int i) {
        return (i-1)/2;
    }
}
