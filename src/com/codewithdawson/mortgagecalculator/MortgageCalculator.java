package com.codewithdawson.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("principal: ", 1_000, 1_000_000);
        float annualPercentInterestRate = (float) readNumber("Annual Interest Rate: ", 1,30);
        byte years = (byte)readNumber("Period (Years): ",1,30);

        printMortgage(principal, annualPercentInterestRate, years);

        printPaymentSchedule(principal, annualPercentInterestRate, years);
    }

    private static void printMortgage(int principal, float annualPercentInterestRate, byte years) {
        double mortgage = calculateMortgage(principal, annualPercentInterestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("---------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principal, float annualPercentInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("------------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualPercentInterestRate, years,month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
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

    public static double calculateBalance(
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

    public static double calculateMortgage(
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
