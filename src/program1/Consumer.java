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

    /**
     * Consumes the next item in the min priority queue
     */
    public void run() {
        int empty = 1;
        int numComplete = 0;
        for (int i = 0; i < id; i++) {
            System.out.print("\t");
        }
        System.out.println("Consumer " + id + " is starting...");

        while (!heap.isEmpty() || finished == false) {
            // Make sure the heap isn't empty
            // If it is, then sleep
            if (heap.isEmpty()) {
                if (empty == 1) {
                    for (int i = 0; i < id; i++) {
                        System.out.print("\t");
                    }
                    System.out.println("Consumer " + id + " is idle...");
                    empty = 0;
                }

                // Sleep
                int sleepTime = 1000;
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            else {
                empty = 1;
                // Grabs the next process
                Node myProcess = heap.extract();

                // Simulate processing time
                int sleepTime = myProcess.getTimeSlice();
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Print out when the process finished
                Date d1 = new Date();
                for (int i = 0; i < id; i++) {
                    System.out.print("\t");
                }
                System.out.println("Consumer " + id + " finished Process: " + myProcess.getProcessID() + " on " + d1);
                numComplete++;
            }
        }
        for (int i = 0; i < id; i++) {
            System.out.print("\t");
        }
        System.out.println("Consumer " + id + " exiting - completed " + numComplete + " processes...");
    }

    /**
     * Sets the finished variable to true to notify the
     * consumer that the producers have finished producing
     */
    public static void finish() {
        finished = true;
    }
}
