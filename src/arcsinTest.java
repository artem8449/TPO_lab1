import org.junit.Test;

import static org.junit.Assert.*;

public class arcsinTest {

    private static final double E  = 1E-6;
    private static final double DELTA = 1E-5;

    @Test
    public void testFuncneginf(){
        double x = Double.NEGATIVE_INFINITY;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFunczona11(){
        double x = -7;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFunczona12(){
        double x = -2;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnnegone(){
        double x = -1;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnnegnegzero8(){
        double x = -0.8;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnnegzona21(){
        double x = -0.97;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnnegzona22(){
        double x = -0.82;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnnegzero(){
        double x = 0;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnzona31(){
        double x = -0.5;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnzona32(){
        double x = -0.01;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }


    @Test
    public void testFuncnnegzero8(){
        double x = 0.8;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }


    @Test
    public void testFuncnzona41(){
        double x = 0.01;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnzona42(){
        double x = 0.5;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnzone(){
        double x = 1;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnzona51(){
        double x = 0.82;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnzona52(){
        double x = 0.97;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncinf(){
        double x = Double.POSITIVE_INFINITY;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnzona61(){
        double x = 7;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }

    @Test
    public void testFuncnzona62(){
        double x = 2;
        assertEquals(Math.asin(x), arcsin.arcsin(x, E), DELTA);
    }
}