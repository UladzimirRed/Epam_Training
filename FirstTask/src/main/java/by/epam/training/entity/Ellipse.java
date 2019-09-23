package by.epam.training.entity;

import by.epam.training.observer.FigureObservable;
import by.epam.training.action.EllipseAction;
import by.epam.training.observer.EllipseEvent;
import by.epam.training.observer.FigureObserver;
import by.epam.training.util.reader.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Ellipse implements Figure, FigureObservable {

    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
    private long id;
    private double radius1;
    private double radius2;
    private Point center;
    private FigureObserver figureObserver;
    private EllipseParametersWarehouse parameters;

    public Ellipse(long id, double radius1, double radius2, Point center) {
        this.id = id;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.center = center;
        parameters = new EllipseParametersWarehouse
                (EllipseAction.calculatePerimeter(radius1, radius2), EllipseAction.calculateSquare(radius1, radius2),
                        EllipseAction.isEllipse(radius1, radius2), EllipseAction.isPointsOnTheSamePlane(radius1, radius2));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRadius1() {
        return radius1;
    }

    public void setRadius1(double radius1) {
        if (radius1 <= 0) {
            LOGGER.info("There was an attempt to set the large radius of the ellipse as a negative number! " +
                    "The variable radius1 is set to the default value = 1");
            radius1 = 1;
        }
        this.radius1 = radius1;
        notifyObserver();
    }

    public double getRadius2() {
        return radius2;
    }

    public void setRadius2(double radius2) {
        if (radius2 <= 0) {
            LOGGER.info("There was an attempt to set the small radius of the ellipse as a negative number! " +
                    "The variable radius1 is set to the default value = 1");
            radius2 = 1;

        }
        this.radius2 = radius2;
        notifyObserver();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObserver();
    }

    public EllipseParametersWarehouse getParameters() {
        return parameters;
    }

    @Override
    public void attach(FigureObserver ellipseObserver) {
        this.figureObserver = ellipseObserver;
    }

    @Override
    public void detach(FigureObserver ellipseObserver) {
        this.figureObserver = null;
    }

    @Override
    public void notifyObserver() {
        figureObserver.handleEvent(new EllipseEvent(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        if (id != ellipse.id) return false;
        if (Double.compare(ellipse.radius1, radius1) != 0) return false;
        if (Double.compare(ellipse.radius2, radius2) != 0) return false;
        if (center != null ? !center.equals(ellipse.center) : ellipse.center != null) return false;
        if (figureObserver != null ? !figureObserver.equals(ellipse.figureObserver) : ellipse.figureObserver != null)
            return false;
        return parameters != null ? parameters.equals(ellipse.parameters) : ellipse.parameters == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(radius1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(radius2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (center != null ? center.hashCode() : 0);
        result = 31 * result + (figureObserver != null ? figureObserver.hashCode() : 0);
        result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ellipse{");
        sb.append("id=").append(id);
        sb.append(", radius1=").append(radius1);
        sb.append(", radius2=").append(radius2);
        sb.append(", center=").append(center);
        sb.append('}');
        return sb.toString();
    }
}
