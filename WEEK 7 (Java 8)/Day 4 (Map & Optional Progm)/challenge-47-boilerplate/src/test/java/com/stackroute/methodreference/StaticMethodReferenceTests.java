package com.stackroute.methodreference;

import com.stackroute.methodreference.StaticMethodReference;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StaticMethodReferenceTests {
    private StaticMethodReference staticMethodReference;

    private static final String MESSAGE = "Check the logic of the method multiply";

    @BeforeEach
    public void setUp() {
        staticMethodReference = new StaticMethodReference();
    }

    @AfterEach
    public void tearDown() {
        staticMethodReference = null;
    }

    @Test
    public void givenPositiveNumbersThenReturnResult() {
        assertEquals(20, staticMethodReference.multiply(5, 4), MESSAGE);
    }

    @Test
    public void givenNegativeNumbersThenReturnResult() {
        assertEquals(16, staticMethodReference.multiply(-4, -4), MESSAGE);
    }

    @Test
    public void givenPositiveAndNegativeNumberThenReturnResult() {
        assertEquals(-16, staticMethodReference.multiply(4, -4), MESSAGE);
    }

    @Test
    public void givenZeroAsInputThenReturnResult() {
        assertEquals(0, staticMethodReference.multiply(0, 0), MESSAGE);
    }

    @Test
    public void givenInputThenReturnResultNotNull() {
        assertNotNull(staticMethodReference.multiply(2, 2), MESSAGE);
    }

    @Test
    public void givenInputAsSameNumberThenReturnResult() {
        assertEquals(4, staticMethodReference.multiply(2, 2), MESSAGE);
    }
}
