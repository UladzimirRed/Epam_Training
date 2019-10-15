package by.epam.training.state;

import by.epam.training.entity.Truck;

public interface TruckState {
    void nextState(Truck truck);

    void printStatus(Truck truck);
}
