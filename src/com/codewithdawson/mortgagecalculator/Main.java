package com.codewithdawson.mortgagecalculator;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("principal: ", 1_000, 1_000_000);
        float annualPercentInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1,30);
        byte years = (byte) Console.readNumber("Period (Years): ",1,30);

        var calculator = new MortgageCalculator(principal, annualPercentInterestRate, years);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
