package by.epam.training.util.builder;

import by.epam.training.entity.Truck;

public class TruckBuilder {

    public static Truck buildTruck(String[] data) {
        return new Truck(Long.parseLong(data[0]), Boolean.parseBoolean(data[1]), Boolean.parseBoolean(data[2]));
    }

}
