package by.epam.training.entity;

public enum KindsOfCandies {
    CHOCOLATE("CHOCOLATE"),
    CARAMEL("CARAMEL"),
    TOFFEE("TOFFEE");

    private final String type;

    KindsOfCandies(final String type) {
        this.type = type;
    }
}
