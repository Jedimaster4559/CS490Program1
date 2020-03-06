package program1;

import java.util.Random;

public class Producer implements Runnable {
    int id;
    int timesAwake;
    Random rand;
    int timesToWakeUp;
    MinHeap<Node> heap;

    /**
     * Creates a new Producer with an id and the heap it should add tasks to
     * @param id The ID of the new producer
     * @param heap The heap the Producer should add to
     */
    public Producer(int id, MinHeap heap){
        this.id = id;
        timesAwake = 0;
        rand = new Random();
        timesToWakeUp = rand.nextInt(Config.MAX_NUM_TIMES_WAKEUP - Config.MIN_NUM_TIMES_WAKEUP) + Config.MIN_NUM_TIMES_WAKEUP;
        this.heap = heap;
    }

    /**
     * Runs the producer. This adds tasks to the Heap at random times
     */
    public void run() {
        System.out.println("Producer " + id + " Starting...");
        while(timesAwake < timesToWakeUp) {
            // Handle sleeping
            int sleepTime = rand.nextInt(Config.MAX_SLEEP_TIME - Config.MIN_SLEEP_TIME) + Config.MIN_SLEEP_TIME;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Add nodes to the heap
            System.out.println("Producer " + id + " is adding Nodes");
            int numProcessToAdd = rand.nextInt(Config.MAX_NUM_PROCESSES - Config.MIN_NUM_PROCESSES) + Config.MIN_NUM_PROCESSES;
            for(int i = 0; i < numProcessToAdd; i++){
                heap.insert(Node.generateNewRandomNode());
            }
            System.out.println("There are " + heap.size() + " elements in the heap.");
            timesAwake++;
        }
    }
}
