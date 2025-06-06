package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Exception.UnsupportedMathOperationException;
import com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Service.MathService;

@RestController
@RequestMapping("/math")
public class MathController {


  @Autowired
  private MathService mathService;
  // http://localhost:8080/math/sum/3/5
  @RequestMapping("/sum/{numberOne}/{numberTwo}")
  public Double sum(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
    return mathService.sum(numberOne, numberTwo);
  }

   @RequestMapping("subtraction/{numberOne}/{numberTwo}")
  public double subtraction(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
    return mathService.subtraction(numberOne, numberTwo);

  }

  @RequestMapping("multi/{numberOne}/{numberTwo}")
  public double multi(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
    
        return mathService.multiplication(numberOne, numberTwo);
  }

  @RequestMapping("division/{numberOne}/{numberTwo}")
  public double division(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
    
        return mathService.division(numberOne, numberTwo);

  }

   @RequestMapping("average/{numberOne}/{numberTwo}")
  public double average(
      @PathVariable("numberOne") String numberOne,
      @PathVariable("numberTwo") String numberTwo) throws IllegalArgumentException {
   
        return mathService.average(numberOne, numberTwo);
  }

   @RequestMapping("square-root/{number}")
  public double squareRoot(
      @PathVariable("number") String number) throws IllegalArgumentException {
   
        return mathService.squareRoot(number);
  }
  

}
