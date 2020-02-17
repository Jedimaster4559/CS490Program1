package program1;
import java.util.*;
import java.util.Random;

public class Consumer implements Runnable {
    int id;
    Random rand;
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

        while (heap.size() >= 1 || finished == false) {
            // Make sure the heap isn't empty
            if (heap.isEmpty()) {
                System.out.println("Consumer " + id + " is idle...");
            }

            else {
                Node myProcess = heap.minimum();

                // Grabs the next process
                heap.extract();

                // Simulate processing time
                int sleepTime = rand.nextInt(Config.MAX_SLEEP_TIME - Config.MIN_SLEEP_TIME) + Config.MIN_SLEEP_TIME;
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Print out when the process finished
                Date d1 = new Date();
                System.out.println("Consumer " + id + " finished Process: " + myProcess.getProcessID() + " on " + d1);
            }
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
