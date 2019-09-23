package by.epam.training.factory;

import by.epam.training.entity.Ellipse;
import by.epam.training.entity.Point;
import by.epam.training.util.IdCreator;

public class EllipseFactory {
    public static Ellipse createEllipse(double radius1, double radius2, Point center) {
        long id = IdCreator.generateId();
        return new Ellipse(id, radius1, radius2, center);
    }
}