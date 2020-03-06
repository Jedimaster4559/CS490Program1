/**
 * This config file contains and values you may want to change while testing the program.
 * Feel free to change these values to change how the program behaves.
 */
package program1;

public class Config {
    // Node Config Values
    public static int MIN_TIME_SLICE = 1000;
    public static int MAX_TIME_SLICE = 10000;
    public static int MIN_PRIORITY = 50;

    // Consumer Config values
    public static int NUM_CONSUMERS = 2;

    // Producer Config values
    public static int NUM_PRODUCERS = 1;
    public static int MIN_NUM_TIMES_WAKEUP = 3;
    public static int MAX_NUM_TIMES_WAKEUP = 10;
    public static int MIN_NUM_PROCESSES = 10;
    public static int MAX_NUM_PROCESSES = 50;
    public static int MIN_SLEEP_TIME = 1000;
    public static int MAX_SLEEP_TIME = 10000;
}
