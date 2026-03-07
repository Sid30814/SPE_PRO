package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import org.example.ScientificCalculator;
public class ScientificCalculatorTest {

    // Your logic methods - Note: Make them static to be accessible

    // --- JUnit Test Methods ---

    @Test
    public void testSqrt() {
        assertEquals(4.0, Math.sqrt(16.0), 0.001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, ScientificCalculator.calculateFactorial(5));
    }
    @Test
    public void testLogarithm() {
        assertEquals(0.0, Math.log(1.0), 0.001);
    }
}