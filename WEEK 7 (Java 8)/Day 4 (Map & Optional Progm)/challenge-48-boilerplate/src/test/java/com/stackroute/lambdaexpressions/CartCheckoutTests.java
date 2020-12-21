package com.stackroute.lambdaexpressions;


import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

public class CartCheckoutTests {

    private CartCheckout cartCheckout;
    private String message = "Check the logic in method billGenerator, method should return error string when";

    @BeforeEach
    public void setUp() {
        cartCheckout = new CartCheckout();
    }

    @AfterEach
    public void tearDown() {
        cartCheckout = null;
    }

    @Test
    public void givenAMapAndDoubleThenReturnAStringResult() {
        String message = "Check the logic in method billGenerator";


        Map<String, BigDecimal> orderListOne = new HashMap<>();
        orderListOne.put("Apple", BigDecimal.valueOf(54));
        orderListOne.put("Orange", BigDecimal.valueOf(23.6));
        orderListOne.put("Banana", BigDecimal.valueOf(10.2));
        orderListOne.put("Grapes", BigDecimal.valueOf(36.78));
        orderListOne.put("Papaya", BigDecimal.valueOf(27.89));

        assertEquals("168.47935", cartCheckout.billGenerator(orderListOne, 10.5), message);
        Map<String, BigDecimal> orderListTwo = new HashMap<>();
        orderListTwo.put("Oral-B Toothbrush", BigDecimal.valueOf(20));
        orderListTwo.put("Dettol", BigDecimal.valueOf(34));
        orderListTwo.put("Pril", BigDecimal.valueOf(26.9));
        orderListTwo.put("Potato", BigDecimal.valueOf(40.89));
        orderListTwo.put("Cauliflower", BigDecimal.valueOf(28.3));
        assertEquals("363.072", cartCheckout.billGenerator(orderListTwo, (double) 20), message);
    }

    @Test
    public void givenANullMapOrNullDoubleThenReturnAnErrorString() {
        Map<String, BigDecimal> orderList = new HashMap<>();
        orderList.put("Oral-B Toothbrush", BigDecimal.valueOf(20));
        orderList.put("Dettol", BigDecimal.valueOf(34));
        orderList.put("Pril", BigDecimal.valueOf(26.9));
        orderList.put("Potato", BigDecimal.valueOf(40.89));
        orderList.put("Cauliflower", BigDecimal.valueOf(28.3));
        assertEquals("The taxPercent cannot be null", cartCheckout.billGenerator(orderList, null), message + " taxPercent is null");
        assertEquals("The cart Map cannot be null", cartCheckout.billGenerator(null, (double) 30), message + " Map is null");
        assertEquals("The taxPercent cannot be null", cartCheckout.billGenerator(null, null), message + " both inputs are null");
    }

    @Test
    public void givenAEmptyMapAndDoubleThenReturnAnErrorString() {
        Map<String, BigDecimal> orderList = new HashMap<>();
        assertEquals("The cart Map is empty", cartCheckout.billGenerator(orderList, 7.5), message + " map is empty");
    }

    @Test
    public void givenAMapAndNegativeDoubleThenReturnAnErrorString() {
        Map<String, BigDecimal> orderListOne = new HashMap<>();
        orderListOne.put("Apple", BigDecimal.valueOf(54));
        orderListOne.put("Orange", BigDecimal.valueOf(23.6));
        orderListOne.put("Banana", BigDecimal.valueOf(10.2));
        orderListOne.put("Grapes", BigDecimal.valueOf(36.78));
        orderListOne.put("Papaya", BigDecimal.valueOf(27.89));
        assertEquals("The taxPercent cannot be negative", cartCheckout.billGenerator(orderListOne, -3.99), message + " taxPercent is negative");
    }

    @Test
    public void givenAMapWithEmptyValueAndDoubleThenReturnAnErrorString() {
        Map<String, BigDecimal> orderListOne = new HashMap<>();
        orderListOne.put("Apple", BigDecimal.valueOf(54));
        orderListOne.put("", BigDecimal.valueOf(23.6));
        orderListOne.put("Banana", BigDecimal.valueOf(10.2));
        orderListOne.put("Grapes", BigDecimal.valueOf(36.78));
        orderListOne.put("Papaya", BigDecimal.valueOf(27.89));
        assertEquals("The cart Map has null or empty or blank space as a value", cartCheckout.billGenerator(orderListOne, (double) 15), message + " map contains empty value");
    }

    @Test
    public void givenAMapWithBlankSpaceValueAndDoubleThenReturnAnErrorString() {
        Map<String, BigDecimal> orderListOne = new HashMap<>();
        orderListOne.put("Apple", BigDecimal.valueOf(54));
        orderListOne.put("Orange", BigDecimal.valueOf(23.6));
        orderListOne.put("Banana", BigDecimal.valueOf(10.2));
        orderListOne.put(" ", BigDecimal.valueOf(36.78));
        orderListOne.put("Papaya", BigDecimal.valueOf(27.89));
        assertEquals("The cart Map has null or empty or blank space as a value", cartCheckout.billGenerator(orderListOne, (double) 15), message + " map contains Blank space value");
    }

    @Test
    public void givenAMapWithNullValueAndDoubleThenReturnAnErrorString() {
        Map<String, BigDecimal> orderListOne = new HashMap<>();
        orderListOne.put("Apple", BigDecimal.valueOf(54));
        orderListOne.put("Orange", BigDecimal.valueOf(23.6));
        orderListOne.put("Banana", BigDecimal.valueOf(10.2));
        orderListOne.put("Grapes", BigDecimal.valueOf(36.78));
        orderListOne.put(null, BigDecimal.valueOf(27.89));
        assertEquals("The cart Map has null or empty or blank space as a value", cartCheckout.billGenerator(orderListOne, (double) 15), message + " map contains null value");
    }

}
