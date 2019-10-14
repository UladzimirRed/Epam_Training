package by.epam.training.state.impl;

import by.epam.training.entity.Truck;
import by.epam.training.state.TruckState;

public class InQueueState implements TruckState {

    @Override
    public void nextState(Truck truck) {
        truck.setTruckState(new ProcessingState());
    }

    @Override
    public void printStatus(Truck truck) {
        System.out.println("Truck " + truck + " is in queue.");
    }
}
