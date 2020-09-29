import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class ArcsinTest {

    private static final double E  = 1E-6;
    private static final double DELTA = 1E-5;


    @Test
    public void testNegativeInfinity(){
        double x = Double.NEGATIVE_INFINITY;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testBelowNegativeOne(){
        double x = -7;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testBelowNegativeOne2(){
        double x = -2;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testNegativeOne(){
        double x = -1;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testNegativeBorder(){
        double x = -0.8;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testNegativeBelowBorder1(){
        double x = -0.97;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testNegativeBelowBorder2(){
        double x = -0.82;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testZero(){
        double x = 0;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testNegativeUpperBorder1(){
        double x = -0.5;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testNegativeUpperBorder2(){
        double x = -0.01;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }


    @Test
    public void testPositiveBorder(){
        double x = 0.8;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }


    @Test
    public void testPositiveBelowBorder1(){
        double x = 0.01;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testPositiveBelowBorder2(){
        double x = 0.5;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testPositiveOne(){
        double x = 1;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testPositiveUpperBorder1(){
        double x = 0.82;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testPositiveUpperBorder2(){
        double x = 0.97;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testPositiveInfinity(){
        double x = Double.POSITIVE_INFINITY;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testAbovePositiveOne(){
        double x = 7;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }

    @Test
    public void testAbovePositiveOne1(){
        double x = 2;
        assertEquals(Math.asin(x), Arcsin.seriesTeilor(x, E), DELTA);
    }
}