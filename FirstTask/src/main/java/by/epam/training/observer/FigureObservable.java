package by.epam.training.observer;

public interface FigureObservable {
    void attach(FigureObserver figureObserver);
    void detach(FigureObserver figureObserver);
    void notifyObserver();
}
