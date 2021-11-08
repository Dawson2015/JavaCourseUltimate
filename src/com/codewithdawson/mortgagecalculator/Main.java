package com.codewithdawson.mortgagecalculator;

public class Main {
    public static void main(String[] args) {
        MortgageCalculator mortgageCalculator = new MortgageCalculator();
        int principal = (int) mortgageCalculator.readNumber("principal: ", 1_000, 1_000_000);
        float annualPercentInterestRate = (float) mortgageCalculator.readNumber("Annual Interest Rate: ", 1,30);
        byte years = (byte)mortgageCalculator.readNumber("Period (Years): ",1,30);

        mortgageCalculator.printMortgage(principal, annualPercentInterestRate, years);

        mortgageCalculator.printPaymentSchedule(principal, annualPercentInterestRate, years);
    }
}
