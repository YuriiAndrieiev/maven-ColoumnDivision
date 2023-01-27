package com.yurii.andrieiev.ua;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.println("print dividend");
    int dividend = scanner.nextInt();
        System.out.println("print divider");
    int divider = scanner.nextInt();
    Calculator calculator = new Calculator();
    DivisionResult divisionResult = calculator.divide(dividend,divider);
    PaintProccessDivision paintProccessDivision = new PaintProccessDivision();
    String end = String.valueOf(paintProccessDivision.paintFullPicture(divisionResult));
        System.out.println(end);
    }
}
