package com.stackroute.lambdaexpressions;

import java.math.BigDecimal;
import java.util.Map;

public class CartCheckout {

    // write here logic to add a Map values include tax using lambda expression
    double amount = 0;

    public String billGenerator(Map<String, BigDecimal> cart, Double taxPercent) {
        if (taxPercent == null)
            return "The taxPercent cannot be null";
        else if (taxPercent < 0)
            return "The taxPercent cannot be negative";
        if (cart == null)
            return "The cart Map cannot be null";
        else if (cart.isEmpty())
            return "The cart Map is empty";
        ;

        for (Map.Entry<String, BigDecimal> entry : cart.entrySet()) {
            if (entry.getKey() == null || entry.getKey().trim().equals(""))
                return "The cart Map has null or empty or blank space as a value";
        }
        // System.out.println(amount);
        cart.forEach((val1, val2) -> {
            amount += val2.doubleValue();
        });
        double decimalTax = taxPercent / 100;

        return String.valueOf(amount + (decimalTax * amount));
    }
}
