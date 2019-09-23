package by.epam.training.observer;

import by.epam.training.action.EllipseAction;
import by.epam.training.entity.Ellipse;

public class EllipseObserver implements FigureObserver {

    @Override
    public void handleEvent(EllipseEvent ellipseEvent) {
        Ellipse ellipse = ellipseEvent.getSource();
        double perimeter = EllipseAction.calculatePerimeter(ellipse);
        double square = EllipseAction.calculateSquare(ellipse);
        boolean isEllipse = EllipseAction.isEllipse(ellipse.getRadius1(), ellipse.getRadius2());
        boolean isPointsOnTheSamePlane = EllipseAction.isPointsOnTheSamePlane(ellipse.getRadius1(), ellipse.getRadius2());
        ellipse.getParameters().setPerimeter(perimeter);
        ellipse.getParameters().setSquare(square);
        ellipse.getParameters().setIsEllipse(isEllipse);
        ellipse.getParameters().setIsPointsOnTheSamePlane(isPointsOnTheSamePlane);
    }
}
