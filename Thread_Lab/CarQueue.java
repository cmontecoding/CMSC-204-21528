import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
    private Queue<Integer> directionsQueue;

    public CarQueue() {
        directionsQueue = new LinkedList<>();
        // Adding 5 or 6 random directions to the queue initially
        Random random = new Random();
        // Generate 5 or 6 random directions
        int numDirections = random.nextInt(2) + 5;
        for (int i = 0; i < numDirections; i++) {
            // Random direction: 0, 1, 2, or 3
            int direction = random.nextInt(4);
            directionsQueue.add(direction);
        }
    }

    public void addToQueue() {
        // Runnable implementation to add random directions to the queue and sleep
        class AddToQueueTask implements Runnable {
            Random random = new Random();
            public void run() {

                try {
                    for (int i = 0; i < 10; i++) {
                        int direction = random.nextInt(4);
                        directionsQueue.add(direction);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // Creating a thread for the runnable task and starting it
        AddToQueueTask addToQueueTask = new AddToQueueTask();
        Thread thread = new Thread(addToQueueTask);
        thread.start();
    }

    public Integer deleteQueue() {
        // Remove and return the direction from the queue (null if empty)
        return directionsQueue.remove();
    }
}
