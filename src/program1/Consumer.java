package program1;

public class Consumer implements Runnable {
    int id;
    MinHeap<Node> heap;
    static boolean finished = false;


    /**
     * Constructor
     * @param id is the Consumer's ID
     * @param heap is the heap with processes to be executed
     */
    public Consumer(int id, MinHeap heap){
        this.id = id;
        this.heap = heap;
    }

    public void run() {
        System.out.println("Consumer " + id + " is starting...");

        while (heap.size() <= 1) {
            System.out.println("Consumer " + id + " is idle...");
        }

    }

    /**
     * Sets the finished variable to true to notify the
     * consumer that the producers have finished producing
     */
    public static void finish() {
        finished = true;
    }
}
