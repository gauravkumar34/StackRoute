package com.stackroute.optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionalDemoTests {
    private OptionalDemo optionalDemo;

    private static final String MESSAGE = "Check the logic of your method concatenateString";

    @BeforeEach
    public void setUp() {
        optionalDemo = new OptionalDemo();
    }

    @AfterEach
    public void tearDown() {
        optionalDemo = null;
    }

    @Test
    public void givenTwoValidStringInputsThenReturnResult() {
        String output = "StackRoute";
        assertEquals(output, optionalDemo.concatenateString("Stack", "Route"), MESSAGE);
    }

    @Test
    public void givenANullValueAndAValidStringInputsThenReturnErrorMessage() {
        String output = "Cannot concatenate with null string";
        assertEquals(output, optionalDemo.concatenateString(null, "Route"), MESSAGE);
    }

    @Test
    public void givenAValidStringAndANullValueInputsThenReturnResult() {
        String output = "StackBangalore";
        assertEquals(output, optionalDemo.concatenateString("Stack", null), MESSAGE);
    }

    @Test
    public void givenTwoNullValuesThenReturnErrorMessage() {
        String output = "Cannot concatenate with null string";
        assertEquals(output, optionalDemo.concatenateString(null, null), MESSAGE);
    }

    @Test
    public void givenAnEmptyStringAndAValidStringInputsThenReturnResult() {
        String output = "Route";
        assertEquals(output, optionalDemo.concatenateString("", "Route"), MESSAGE);

    }

    @Test
    public void givenAValidStringAndAnEmptyStringInputsThenReturnResult() {
        String output = "Stack";
        assertEquals(output, optionalDemo.concatenateString("Stack", ""), MESSAGE);

    }

    @Test
    public void givenTwoEmptyStringInputsThenReturnResult() {
        String output = "";
        assertEquals(output, optionalDemo.concatenateString("", ""), MESSAGE);

    }
}