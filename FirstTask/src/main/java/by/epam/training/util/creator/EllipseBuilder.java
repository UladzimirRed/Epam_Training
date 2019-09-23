package by.epam.training.util.creator;

import by.epam.training.entity.Ellipse;
import by.epam.training.entity.Point;
import by.epam.training.factory.EllipseFactory;

public class EllipseBuilder {

    public static Ellipse buildEllipse(double x1, double y1, double x2, double y2) {
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);

        double radius1 = findSideOfRectangle(point1.getCoordinateX(), point2.getCoordinateX()) / 2;
        double radius2 = findSideOfRectangle(point1.getCoordinateY(), point2.getCoordinateY()) / 2;

        Point center = findCenter(point1, point2);
        return EllipseFactory.createEllipse(radius1, radius2, center);
    }

    public static double findSideOfRectangle(double coordinateX, double coordinateY) {
        return Math.abs(coordinateX - coordinateY);
    }

    public static Point findCenter(Point point1, Point point2) {
        double coordinateX = findAverageBetweenTwoPoints(point1.getCoordinateX(), point2.getCoordinateX());
        double coordinateY = findAverageBetweenTwoPoints(point1.getCoordinateY(), point2.getCoordinateY());
        return new Point(coordinateX, coordinateY);
    }

    public static double findAverageBetweenTwoPoints(double coordinate1, double coordinate2) {
        return (coordinate1 + coordinate2) / 2;
    }

}
