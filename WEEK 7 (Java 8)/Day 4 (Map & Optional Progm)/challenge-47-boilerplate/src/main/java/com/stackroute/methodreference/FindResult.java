package com.stackroute.methodreference;

public class FindResult {
  // write logic to find multiplication result of given numbers
  // Use static method multiply of StaticMethodReference class
  public int findResult(int number1, int number2) {
    StaticMethodReference staticMethodReference = new StaticMethodReference();
    int result = staticMethodReference.multiply(number1, number2);
    return new Integer(result);
  }
}
