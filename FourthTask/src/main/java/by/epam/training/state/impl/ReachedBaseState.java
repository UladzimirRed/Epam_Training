package by.epam.training.state.impl;

import by.epam.training.entity.Truck;
import by.epam.training.state.TruckState;

public class ReachedBaseState implements TruckState {

    @Override
    public void nextState(Truck truck) {
        truck.setTruckState(new InQueueState());
    }

    @Override
    public void printStatus(Truck truck) {
        System.out.println("Truck" + truck + " reached the base.");
    }
}
