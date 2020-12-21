package com.stackroute.datetime;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;



public class FindDayTests {
    private FindDay findDay;

    private static final String MESSAGE = "Check the logic of your method findDay";
    private static final String MESSAGE_DAY_ERROR = "Give day in range";
    private static final String MESSAGE_MONTH_ERROR = "Give month in range";
    private static final String MESSAGE_YEAR_ERROR = "Give year in range";

    @BeforeEach
    public void setUp() {
        findDay = new FindDay();
    }

    @AfterEach
    public void tearDown() {
        findDay = null;
    }

    @Test
    public void givenInputToCheckFriday() {
        assertEquals("FRIDAY", findDay.findDay(1, 3, 2020), MESSAGE);
    }

    @Test
    public void givenInputToCheckSunday() {
        assertEquals("SUNDAY", findDay.findDay(1, 26, 2020), MESSAGE);
    }

    @Test
    public void givenInputToCheckSaturday() {
        assertEquals("SATURDAY", findDay.findDay(1, 4, 2020), MESSAGE);
    }

    @Test
    public void givenInputToCheckMonday() {
        assertEquals("MONDAY", findDay.findDay(6, 22, 2020), MESSAGE);
    }

    @Test
    public void givenInputToCheckTuesday() {
        assertEquals("TUESDAY", findDay.findDay(1, 28, 2020), MESSAGE);
    }

    @Test
    public void givenInputToCheckWednesday() {
        assertEquals("WEDNESDAY", findDay.findDay(4, 8, 2020), MESSAGE);
    }

    @Test
    public void givenInputToCheckThursday() {
        assertEquals("THURSDAY", findDay.findDay(2, 6, 2020), MESSAGE);
    }

    @Test
    public void givenInputToCheckYearGreater3000ThenReturnErrorString() {
        assertEquals(MESSAGE_YEAR_ERROR, findDay.findDay(1, 1, 3001), MESSAGE);
    }

    @Test
    public void givenInputToCheckMonthGreater12ThenReturnErrorString() {
        assertEquals(MESSAGE_MONTH_ERROR, findDay.findDay(13, 2, 2010), MESSAGE);
    }

    @Test
    public void givenInputToCheckDayGreater31ThenReturnErrorString() {
        assertEquals(MESSAGE_DAY_ERROR, findDay.findDay(2, 32, 2020), MESSAGE);
    }

    @Test
    public void givenInputToCheckDayWithNegativeThenReturnErrorString() {
        assertEquals(MESSAGE_DAY_ERROR, findDay.findDay(2, -1, 2020), MESSAGE);
    }

    @Test
    public void givenInputWithMonthAndDayToCheckWithZeroThenReturnErrorString() {
        assertEquals(MESSAGE_MONTH_ERROR + MESSAGE_DAY_ERROR, findDay.findDay(0, 0, 2020), MESSAGE);
    }

    @Test
    public void givenInputWithMonthAndYearToCheckWithZeroThenReturnErrorString() {
        assertEquals(MESSAGE_MONTH_ERROR + MESSAGE_YEAR_ERROR, findDay.findDay(0, 4, 0), MESSAGE);
    }

    @Test
    public void givenInputWithDayAndYearToCheckWithZeroThenReturnErrorString() {
        assertEquals(MESSAGE_DAY_ERROR + MESSAGE_YEAR_ERROR, findDay.findDay(4, 0, 0), MESSAGE);
    }

    @Test
    public void givenInputWithCheckAllWithZeroThenReturnErrorString() {
        assertEquals(MESSAGE_MONTH_ERROR + MESSAGE_DAY_ERROR + MESSAGE_YEAR_ERROR, findDay.findDay(0, 0, 0), MESSAGE);
    }
}
