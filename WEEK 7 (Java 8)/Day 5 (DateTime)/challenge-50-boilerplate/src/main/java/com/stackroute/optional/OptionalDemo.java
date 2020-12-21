package com.stackroute.optional;

import java.util.Optional;

public class OptionalDemo {

    public String concatenateString(String inputOne, String inputTwo) {
        /* When inputTwo is null, then concatenate with defaultString */
        final String defaultString = "Bangalore";
        String stringOne = inputOne;
        String stringTwo = inputTwo;

        /* Optional.ofNullable - allows passed parameter to be null. */
        Optional<String> optionalValueOne;
        Optional<String> optionalValueTwo;

        /*
         * check if optionalValueOne is present, then implement logic to concat strings
         * and return the output string
         */
        optionalValueOne = Optional.ofNullable(inputOne);
        optionalValueTwo = Optional.ofNullable(inputTwo);
        if (optionalValueOne.isPresent() && optionalValueTwo.isPresent())
            return stringOne.concat(stringTwo);

        stringTwo = null;
        if ((optionalValueOne.isPresent()))
            return stringOne.concat(defaultString);
        /* gets the value of optionalValueOne */
        stringOne = null;
        if (!(optionalValueOne.isPresent()))
            return "Cannot concatenate with null string";
        /*
         * returns the value optionalValueTwo if present otherwise returns the
         * "defaultString"
         */

        /* else return string message, if optionalValueOne is not present */

        return null;

    }
}
/**
 * *Second Method without optional if (inputOne == null) return "Cannot
 * concatenate with null string"; else if (inputTwo == null) return
 * inputOne.concat(defaultString); else if (inputOne == null && inputTwo ==
 * null) return "Cannot concatenate with null string"; else return
 * inputOne.concat(inputTwo);
 */