package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.request.converters;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Exception.UnsupportedMathOperationException;

public class NumberConverter {
    
    
      public static Double convertToDouble(String strNumber) throws IllegalArgumentException {
    if (strNumber == null || strNumber.isEmpty())
      throw new UnsupportedMathOperationException("Please set a numeric value");
    String number = strNumber.replace(",", ".");
    return Double.parseDouble(number);

  }

  public static boolean isNumeric(String strNumber) {
    if (strNumber == null || strNumber.isEmpty()) {
      return false;
    }
    String number = strNumber.replace(",", ".");
    return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));

  }
}
