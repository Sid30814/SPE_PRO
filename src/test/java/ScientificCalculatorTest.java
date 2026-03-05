import static org.junit.Assert.*;
import org.junit.Test;

public class ScientificCalculatorTest {
    private static final double DELTA = 1e-15;

    @Test
    public void testSquareRoot() {
        assertEquals(4.0, Math.sqrt(16.0), DELTA);
        assertEquals(3.0, Math.sqrt(9.0), DELTA);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, ScientificCalculator.calculateFactorial(5));
        assertEquals(1, ScientificCalculator.calculateFactorial(0));
    }

    @Test
    public void testNaturalLog() {
        assertEquals(0.0, Math.log(1.0), DELTA);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Math.pow(2.0, 3.0), DELTA);
    }
}