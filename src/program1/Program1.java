package program1;

import java.util.ArrayList;

public class Program1 {
    public static void main(String[] args){
        // Create producers
        ArrayList<Thread> producers = new ArrayList<>();
        for(int i = 0; i < Config.NUM_PRODUCERS; i++){
            Producer p = new Producer(i);
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
        }

        // Notify Consumers that all producers are done

    }
}
