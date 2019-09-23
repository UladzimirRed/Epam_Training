package by.epam.training.action;

import org.testng.Assert;
import by.epam.training.entity.Ellipse;
import by.epam.training.entity.Point;
import org.testng.annotations.Test;


public class EllipseActionTest {
    private Ellipse ellipse = new Ellipse(0, 3, 2, new Point(3, 1));
    private double radius1 = 2;
    private double radius2 = 3;
    private double diameter1 = radius1 * 2;
    private double diameter2 = radius2 * 2;
    private double expectedPerimeter = diameter1 * ((Math.PI * diameter2 * diameter1 + Math.abs(diameter2 - diameter1))
            / (diameter1 + diameter2));
    private double expectedSquare = Math.PI * radius1 * radius2;

    @Test
    public void calculateParameterByEllipseTest() {
        double actualPerimeter = EllipseAction.calculatePerimeter(ellipse);
        Assert.assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    public void calculateParameterByRadiusTest() {
        double actualPerimeter = EllipseAction.calculatePerimeter(3, 2);
        Assert.assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    public void calculateSquareByEllipseTest() {
        double actualSquare = EllipseAction.calculateSquare(ellipse);
        Assert.assertEquals(expectedSquare, actualSquare);
    }

    @Test
    public void calculateSquareByRadiusTest() {
        double actualSquare = EllipseAction.calculateSquare(radius1, radius2);
        Assert.assertEquals(expectedSquare, actualSquare);
    }

    @Test
    public void isPointsOnTheSamePlaneTest() {
        Assert.assertFalse(EllipseAction.isPointsOnTheSamePlane(radius1, radius2));
    }

    @Test
    public void isEllipseTest() {
        Assert.assertTrue(EllipseAction.isEllipse(radius1, radius2));
    }


}
