package program1;

import java.util.ArrayList;

public class Program1 {
    public static void main(String[] args){
        // Initialize Heap
        MinHeap<Node> heap = new MinHeap<>();

        // Create producers
        ArrayList<Thread> producers = new ArrayList<>();
        for(int i = 0; i < Config.NUM_PRODUCERS; i++){
            Producer p = new Producer(i, heap);
            Thread t = new Thread(p);
            producers.add(t);
            t.start();
        }


        // Check if all producers are complete
        boolean complete = false;
        while(!complete){
            complete = true;
            for(Thread t : producers){
                if(t.isAlive()){
                    complete = false;
                    break;
                }
            }
            System.out.println("There are " + heap.size() + " elements in the heap.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Notify Consumers that all producers are done

    }
}
