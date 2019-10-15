package by.epam.training.entity;

import by.epam.training.queue.TruckPriorityQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Terminal implements Runnable {
    private TruckPriorityQueue truckPriorityQueue = TruckPriorityQueue.getInstance();
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (truckPriorityQueue.isEmpty()) {
                    TimeUnit.SECONDS.sleep(5);
                    if (truckPriorityQueue.isEmpty()) {
                        break;
                    }
                }
                TimeUnit.SECONDS.sleep(1);
                Truck truck = truckPriorityQueue.pollTruck();
                if (truck != null) {
                    if (truck.isLoaded()) {
                        truck.setLoaded(false);
                    } else {
                        truck.setLoaded(true);
                    }
                    TimeUnit.SECONDS.sleep(1);
                    truck.nextState();
                }
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
