package by.epam.training.action;

import by.epam.training.entity.Ellipse;

public class EllipseAction {
    public static double calculatePerimeter(Ellipse ellipse) {
        double diameter1 = ellipse.getRadius1() * 2;
        double diameter2 = ellipse.getRadius2() * 2;
        return 4 * ((Math.PI * diameter1 * diameter2 + Math.abs(diameter1 - diameter2)) / (diameter1 + diameter2));
    }

    public static double calculatePerimeter(double radius1, double radius2) {
        double diameter1 = radius1 * 2;
        double diameter2 = radius2 * 2;
        return 4 * ((Math.PI * diameter1 * diameter2 + Math.abs(diameter1 - diameter2)) / (diameter1 + diameter2));
    }

    public static double calculateSquare(Ellipse ellipse) {
        return Math.PI * ellipse.getRadius1() * ellipse.getRadius2();
    }

    public static double calculateSquare(double radius1, double radius2) {
        return Math.PI * radius1 * radius2;
    }

    public static boolean isPointsOnTheSamePlane(double radius1, double radius2) {
        if (radius1 == 0 || radius2 == 0) {
            return true;
        } else return false;
    }

    public static boolean isEllipse(double radius1, double radius2) {
        if (radius1 != radius2) {
            return true;
        } else return false;
    }
}
