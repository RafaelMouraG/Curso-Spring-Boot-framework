package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service;

import org.springframework.stereotype.Service;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Exception.UnsupportedMathOperationException;

@Service
public class MathService {
      public Double sum(String numberOne, String numberTwo) {
        validateInput(numberOne, numberTwo);
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    
    public Double subtraction(String numberOne, String numberTwo) {
        validateInput(numberOne, numberTwo);
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    
    public Double multiplication(String numberOne, String numberTwo) {
        validateInput(numberOne, numberTwo);
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    
    public Double division(String numberOne, String numberTwo) {
        validateInput(numberOne, numberTwo);
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    
    public Double average(String numberOne, String numberTwo) {
        validateInput(numberOne, numberTwo);
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number){
      validateInput(number, number);
      return Math.sqrt(convertToDouble(number));
    }
    

     private void validateInput(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
    }

     private Double convertToDouble(String strNumber) throws IllegalArgumentException {
    if (strNumber == null || strNumber.isEmpty())
      throw new UnsupportedMathOperationException("Please set a numeric value");
    String number = strNumber.replace(",", ".");
    return Double.parseDouble(number);

  }

  private boolean isNumeric(String strNumber) {
    if (strNumber == null || strNumber.isEmpty()) {
      return false;
    }
    String number = strNumber.replace(",", ".");
    return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));

  }
}
