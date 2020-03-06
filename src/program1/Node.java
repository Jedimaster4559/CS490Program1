package program1;

import java.util.Random;

public class Node implements Comparable<Node> {
    private int processID;
    private int priority;
    private int timeSlice;
    private static int nextProcessID = 0;
    private static Object pIDLock = new Object();

    /**
     * Generates a random node using the values in the config file as bounds
     * @return
     */
    public static Node generateNewRandomNode(){
        Random rand = new Random();
        return new Node(rand.nextInt(Config.MIN_PRIORITY), rand.nextInt(Config.MAX_TIME_SLICE - Config.MIN_TIME_SLICE) + Config.MIN_TIME_SLICE);
    }

    /**
     * Creates a default Node. This mostly exists just so things don't break if someone accidentally calls just Node
     */
    public Node(){
        processID = getNewProcessID();
        priority = 0;
        timeSlice = 1;
    }

    /**
     * Creates a new Node given a priority and a Time Slice
     * @param priority The Priority of the process
     * @param timeSlice The amount of time the process takes to run
     */
    public Node(int priority, int timeSlice){
        this.processID = getNewProcessID();
        this.priority = priority;
        this.timeSlice = timeSlice;
    }

    public int getProcessID(){
        return processID;
    }

    public int getPriority(){
        return priority;
    }

    public int getTimeSlice(){
        return timeSlice;
    }

    /**
     * Compares two nodes
     * @param o the other node to compare to
     * @return the difference in priority between the nodes
     */
    public int compareTo(Node o){
        if(this.priority != o.priority){
            return this.priority - o.priority;
        } else {
            return this.processID - o.processID;
        }
    }

    /**
     * Gets a new Process ID. These values increment and are unique
     * @return The next Process ID
     */
    private int getNewProcessID(){
        synchronized (pIDLock) {
            return nextProcessID++;
        }
    }
}
