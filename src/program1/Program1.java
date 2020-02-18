package program1;

import program1.ui.UIMain;

import java.util.ArrayList;

public class Program1 {
    public static void main(String[] args){
        // Initialize GUI
        UIMain ui = new UIMain();
        Thread uit = new Thread(ui);
        uit.start();

        // Initialize Heap
        MinHeap<Node> heap = new MinHeap<>();

        // Create producers
        ArrayList<Thread> producers = new ArrayList<>();
        for(int i = 0; i < Config.NUM_PRODUCERS; i++) {
            Producer p = new Producer(i, heap);
            Thread t = new Thread(p);
            producers.add(t);
            t.start();
        }

        // Create consumers
        ArrayList<Thread> consumers = new ArrayList<>();
        for(int i = 0; i < Config.NUM_CONSUMERS; i++) {
            Consumer c = new Consumer(i, heap);
            Thread t2 = new Thread(c);
            consumers.add(t2);
            t2.start();
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
        Consumer.finish();

    }
}
