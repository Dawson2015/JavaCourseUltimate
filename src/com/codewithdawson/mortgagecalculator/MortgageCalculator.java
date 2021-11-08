package com.codewithdawson.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    private final  byte MONTHS_IN_YEAR = 12;
    private final  byte PERCENT = 100;

    private int principal;
    private float annualPercentInterestRate;
    private int years;

    public void printMortgage(int principal, float annualPercentInterestRate, byte years) {
        double mortgage = calculateMortgage(principal, annualPercentInterestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }


    public void printPaymentSchedule(int principal, float annualPercentInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("------------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualPercentInterestRate, years,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value > min && value <= max)
                break;
            System.out.println("Enter a value between " + (int)min + " and " + (int)max);
        }
        return value;
    }

    private double calculateBalance(
            int principal,
            float annualPercentInterestRate,
            byte years,
            short numberOfPaymentsMade) {

        short totalNumberOfPayments =(short) (years * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualPercentInterestRate/PERCENT/MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - Math.pow(1 + monthlyInterestRate,numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate,totalNumberOfPayments) - 1);

        return balance;
    }

    private double calculateMortgage(
            int principal,
            float annualPercentInterestRate,
            byte years) {

        short numberOfPayments =(short) (years * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualPercentInterestRate/PERCENT/MONTHS_IN_YEAR;

        double mortgage = principal
                *((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                /(Math.pow(1+monthlyInterestRate,numberOfPayments)-1));

        return mortgage;
    }
}
