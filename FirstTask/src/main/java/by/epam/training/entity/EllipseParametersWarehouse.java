package by.epam.training.entity;


public class EllipseParametersWarehouse {
    private double perimeter;
    private double square;
    private boolean isEllipse;
    private boolean isPointsOnTheSamePlane;

    public EllipseParametersWarehouse(double perimeter, double square, boolean isEllipse, boolean isPointsOnTheSamePlane) {
        this.perimeter = perimeter;
        this.square = square;
        this.isEllipse = isEllipse;
        this.isPointsOnTheSamePlane = isPointsOnTheSamePlane;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public boolean getIsEllipse() {
        return isEllipse;
    }

    public void setIsEllipse(boolean isEllipse) {
        this.isEllipse = isEllipse;
    }

    public boolean getIsPointsOnTheSamePlane() {
        return isPointsOnTheSamePlane;
    }

    public void setIsPointsOnTheSamePlane(boolean pointsOnTheSamePlane) {
        isPointsOnTheSamePlane = pointsOnTheSamePlane;
    }
}
