package by.epam.training.util.creator;

import by.epam.training.entity.Point;
import by.epam.training.entity.Ellipse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EllipseBuilderTest {

    @Test
    public void buildEllipseTest() {
        Ellipse expectedEllipse = new Ellipse(0, 3, 2, new Point(3, 1));
        Ellipse actualEllipse = EllipseBuilder.buildEllipse(6, -1, 0, 3);
        Assert.assertEquals(actualEllipse, expectedEllipse);
    }

    @Test
    public void findSideOfRectangleTest() {
        double expectedSide = Math.abs(5 - 2);
        double actualSide = EllipseBuilder.findSideOfRectangle(5, 2);
        Assert.assertEquals(expectedSide, actualSide);
    }

    @Test
    public void findCenterTest() {
        Point actualCenter = new Point(3, 1);
        Point expectedCenter = EllipseBuilder.findCenter(new Point(6, -1), new Point(0, 3));
        Assert.assertEquals(expectedCenter, actualCenter);
    }

    @Test
    public void findAverageBetweenTwoPointsTest() {
        double expectedAverage = 5;
        double actualAverage = EllipseBuilder.findAverageBetweenTwoPoints(2, 8);
        Assert.assertEquals(expectedAverage, actualAverage);
    }


}
