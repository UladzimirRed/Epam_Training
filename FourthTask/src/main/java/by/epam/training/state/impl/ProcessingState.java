package by.epam.training.state.impl;

import by.epam.training.entity.Truck;
import by.epam.training.state.TruckState;

public class ProcessingState implements TruckState {

    @Override
    public void nextState(Truck truck) {
        truck.setTruckState(new FinishedState());
    }

    @Override
    public void printStatus(Truck truck) {
        System.out.println("Truck " + truck + " is processing.");

    }
}
