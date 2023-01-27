package com.yurii.andrieiev.ua;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest  {

    @Test
    void divideWhenWeHaveDividendLikeCurrentDividendInt() {
        Calculator calculator = new Calculator();
        DivisionResult expectedDivisionResult = calculator.divide(20, 10);
        List<CurrentResult> expectedCurrentResults = List.of(new CurrentResult(20, 20, 0));
        assertEquals(expectedDivisionResult, calculator.divide(20, 10));
    }

    @Test
    void calculatorShouldReturnOneCurrentResultWithoutZero() {
        Calculator calculator = new Calculator();
        DivisionResult expectedDivisionResult = calculator.divide(36000, 36);
        List<CurrentResult> expectedCurrentResults = List.of(new CurrentResult(36, 36, 0));
        assertEquals(expectedDivisionResult, calculator.divide(36000, 36));
    }

    @Test
    void divideShouldReturnSevenCurrentResultsWithVariousLength() {
        Calculator calculator = new Calculator();
        DivisionResult expectedDivisionResult = calculator.divide(347343203, 21);
        DivisionResult divisionResult = calculator.divide(347343203, 21);
        List<CurrentResult> expectedCurrentResults = List.of(new CurrentResult(34, 21, 0),
                new CurrentResult(137, 126, 1),
                new CurrentResult(113, 105, 2),
                new CurrentResult(84, 84, 0),
                new CurrentResult(32, 21, 0),
                new CurrentResult(110, 105, 2),
                new CurrentResult(53, 42, 0));
        assertEquals(expectedDivisionResult, divisionResult);
    }

    @Test
    void divideShouldReturnComparisonBetweenCurrentResults() {
        Calculator calculator = new Calculator();
        DivisionResult expectedDivisionResult = calculator.divide(347343203, 21);
        DivisionResult divisionResult = calculator.divide(347343203, 21);
        List<CurrentResult> expectedCurrentResults = List.of(new CurrentResult(34, 21, 0),
                new CurrentResult(137, 126, 1),
                new CurrentResult(113, 105, 2),
                new CurrentResult(84, 84, 0),
                new CurrentResult(32, 21, 0),
                new CurrentResult(110, 105, 2),
                new CurrentResult(53, 42, 0));
        assertEquals(expectedCurrentResults, divisionResult.getCurrentResults());
    }

    @Test
    void divideShouldReturnThreeTheSameCurrentResults() {
        Calculator calculator = new Calculator();
        List<CurrentResult>expectedCurrentResults = List.of(new CurrentResult(36, 36, 0),
                new CurrentResult(36, 36, 0),
                new CurrentResult(36, 36, 0));
        DivisionResult expectedDivisionResult = new DivisionResult(363636, 36, 10101, expectedCurrentResults);
        DivisionResult divisionResult = calculator.divide(363636, 36);
        assertEquals(expectedDivisionResult, calculator.divide(363636, 36));
    }
}
