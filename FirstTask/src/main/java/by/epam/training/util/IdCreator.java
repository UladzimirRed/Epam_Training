package by.epam.training.util;

public class IdCreator {
    private static long idCounter = 0;

    public static long generateId() {
        return idCounter++;
    }
}