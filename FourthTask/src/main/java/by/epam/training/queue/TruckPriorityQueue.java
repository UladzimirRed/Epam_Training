package by.epam.training.queue;

import by.epam.training.entity.Truck;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

public enum TruckPriorityQueue {
    //todo if you want, rewrite singleton
    INSTANCE;
    private ReentrantLock lock = new ReentrantLock();

    private PriorityQueue<Truck> priorityQueue = new PriorityQueue<>(Comparator.comparing(Truck::isPerishableCargo).reversed());

    public void addTruck(Truck truck) {
        lock.lock();
        if (truck != null) {
            priorityQueue.add(truck);
            truck.nextState();
        }
        lock.unlock();
    }

    public boolean isEmpty() {
        lock.lock();
        boolean empty = priorityQueue.isEmpty();
        lock.unlock();
        return empty;
    }


    public Truck pollTruck() {
        lock.lock();
        Truck truck = priorityQueue.poll();
        if (truck != null) {
            truck.nextState();
        }
        lock.unlock();
        return truck;
    }
}
