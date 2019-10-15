package by.epam.training.entity;

import by.epam.training.state.TruckState;
import by.epam.training.state.impl.FinishedState;
import by.epam.training.state.impl.ReachedBaseState;

public class Truck implements Runnable {
    private long id;
    private boolean perishableCargo;
    private boolean loaded;
    private TruckState truckState;

    public Truck(long id, boolean loaded, boolean perishableCargo) {
        this.id = id;
        this.loaded = loaded;
        this.perishableCargo = perishableCargo;
        truckState = new ReachedBaseState();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPerishableCargo() {
        return perishableCargo;
    }

    public void setPerishableCargo(boolean perishableCargo) {
        this.perishableCargo = perishableCargo;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {

        this.loaded = loaded;

    }

    public TruckState getTruckState() {
        return truckState;
    }

    public void setTruckState(TruckState truckState) {
        this.truckState = truckState;
    }

    public void nextState() {
        truckState.nextState(this);
        printState();
    }

    public void printState() {
        truckState.printStatus(this);
    }

    @Override
    public void run() {
        printState();
        while (true) {
            if (truckState instanceof FinishedState) {
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;

        if (id != truck.id) return false;
        return perishableCargo == truck.perishableCargo;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (perishableCargo ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Truck{");
        sb.append("id=").append(id);
        sb.append(", perishableCargo=").append(perishableCargo);
        sb.append(", loaded=").append(loaded);
        sb.append('}');
        return sb.toString();
    }
}
