import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EulerTest {

    Euler euler;

    @Before
    public void setup() {
        euler = new Euler();
    }

    @Test
    public void testProblem1() {
        int actual = euler.problem1();
        assertEquals(233168, actual);
    }

    @Test
    public void testProblem2() {
        long actual = euler.problem2();
        assertEquals(4613732L, actual);
    }

    @Test
    public void testProblem3() {
        long actual = euler.problem3();
        assertEquals(6857L, actual);
    }

    @Test
    public void testProblem4() {
        long actual = euler.problem4();
        assertEquals(906609L, actual);
    }

    @Test
    public void testProblem5() {
        long actual = euler.problem5();
        assertEquals(232792560L, actual);
    }

}
