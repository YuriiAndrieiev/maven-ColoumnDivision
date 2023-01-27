package com.yurii.andrieiev.ua;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public DivisionResult divide(int dividend, int divider) {
        String dividendString = Integer.toString(dividend);
        String[] splitDividend = dividendString.split("");
        List<CurrentResult> currentResults = new ArrayList<>();
        StringBuilder currentDividend = new StringBuilder();
        currentDividend.append(splitDividend[0]);
        for (int i = 0; i < splitDividend.length; ) {
            if (dividend > 9) {
                if (i == splitDividend.length - 1) {
                    break;
                }
                if (Integer.parseInt(String.valueOf(currentDividend)) == 0) {
                    currentDividend.append(splitDividend[i + 1]);
                    i++;
                }
                if (i == splitDividend.length - 1) {
                    if (Integer.parseInt(String.valueOf(currentDividend)) == 0) {
                        break;
                    }
                }
                while (Integer.parseInt(String.valueOf(currentDividend)) < divider) {
                    if (i == splitDividend.length - 1 ) {
                        if (Integer.parseInt(String.valueOf(currentDividend)) < divider) {
                            break;
                        }
                    } else if (i < splitDividend.length - 1) {
                        i++;
                        currentDividend.append(splitDividend[i]);
                    }
                }
            }else{
                if (Integer.parseInt(String.valueOf(currentDividend)) == 0) {
                    break;
                }
                while (Integer.parseInt(String.valueOf(currentDividend)) < divider) {
                    if (i < splitDividend.length - 1) {
                        i++;
                        currentDividend.append(splitDividend[i]);
                    }
                }
            }
            int currentDividendInt =  Integer.parseInt(String.valueOf(currentDividend));
            int dividerResult = currentDividendInt % divider;
            int numberSubtracted = currentDividendInt - dividerResult;
            int spaceDifference = 0;
            if (currentDividendInt != numberSubtracted) {
                spaceDifference = Integer.toString(currentDividendInt).length() - Integer.toString(dividerResult).length();
            }
            currentDividend.delete(0, currentDividend.length());
            currentDividend.append(dividerResult);
            CurrentResult currentResult = new CurrentResult(currentDividendInt, numberSubtracted, spaceDifference);
            currentResults.add(currentResult);
        }
        return new DivisionResult(dividend, divider, dividend / divider, currentResults);
    }
}
