package by.epam.training.main;

import by.epam.training.entity.LogisticBase;
import by.epam.training.entity.Terminal;
import by.epam.training.entity.Truck;
import by.epam.training.queue.TruckPriorityQueue;
import by.epam.training.util.TruckCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        LogisticBase logisticBase = LogisticBase.getInstance();
        logisticBase.setNumberOfTerminals(2);
        Random random = new Random();
        List<Truck> trucks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            trucks.add(new Truck(random.nextBoolean(), random.nextBoolean()));
        }
        new Thread(new TruckCreator(trucks)).start();

        new Thread(logisticBase).start();

    }

}
