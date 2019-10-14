package by.epam.training.state.impl;

import by.epam.training.entity.Truck;
import by.epam.training.state.TruckState;

public class FinishedState implements TruckState {

    @Override
    public void nextState(Truck truck) {
        printStatus(truck);
    }

    @Override
    public void printStatus(Truck truck) {
        System.out.println("Truck " + truck + " finished processing and leaving base;");
    }
}
