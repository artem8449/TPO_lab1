import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArcsinSeriesExpansionTest {
    private static final double EPS = 1E-6;
    private static final double DELTA = 0.01;

    @Test
    public void testNegativeInfinity(){
        double x = Double.NEGATIVE_INFINITY;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testBelowNegativeOne(){
        double x = -2;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testNegativeOne(){
        double x = -1;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testNearNegativeOne(){
        double x = -0.97;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testNegativeHalf(){
        double x = -0.5;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testZero(){
        double x = 0;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testPositiveHalf(){
        double x = 0.5;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testNearPositiveOne(){
        double x = 0.97;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testPositiveOne(){
        double x = 1;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testAbovePositiveOne(){
        double x = 2;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

    @Test
    public void testPositiveInfinity(){
        double x = Double.POSITIVE_INFINITY;
        assertEquals(Math.asin(x), ArcsinSeriesExpansion.expanse(x, EPS), DELTA);
    }

}
