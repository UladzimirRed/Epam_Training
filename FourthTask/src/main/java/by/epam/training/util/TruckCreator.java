package by.epam.training.util;

import by.epam.training.entity.Truck;
import by.epam.training.queue.TruckPriorityQueue;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TruckCreator implements Runnable {
    private List<Truck> trucks;

    public TruckCreator(List<Truck> trucks) {
        this.trucks = trucks;
    }

    @Override
    public void run() {
        for (Truck truck : trucks) {
            try {
                new Thread(truck).start();
                TimeUnit.SECONDS.sleep(1);
                TruckPriorityQueue.INSTANCE.addTruck(truck);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
