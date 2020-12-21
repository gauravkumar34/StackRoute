package com.stackroute.methodreference;

import com.stackroute.methodreference.FindResult;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class FindResultTests {
    private FindResult findResult;

    private static final String MESSAGE = "Check the logic of the method findResult";

    @BeforeEach
    public void setUp() {
        findResult = new FindResult();
    }

    @AfterEach
    public void tearDown() {
        findResult = null;
    }

    @Test
    public void givenPositiveNumbersThenReturnResult() {
        assertEquals(20, findResult.findResult(5, 4), MESSAGE);
    }

    @Test
    public void givenNegativeNumbersThenReturnResult() {
        assertEquals(16, findResult.findResult(-4, -4), MESSAGE);
    }

    @Test
    public void givenPositiveAndNegativeNumberThenReturnResult() {
        assertEquals(-16, findResult.findResult(4, -4), MESSAGE);
    }

    @Test
    public void givenZeroAsInputThenReturnResult() {
        assertEquals(0, findResult.findResult(0, 0), MESSAGE);
    }

    @Test
    public void givenInputThenReturnResultNotNull() {
        assertNotNull(findResult.findResult(2, 2), MESSAGE);
    }

    @Test
    public void givenInputAsSameNumberThenReturnResult() {
        assertEquals(4, findResult.findResult(2, 2), MESSAGE);
    }
}
