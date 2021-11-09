package com.codewithdawson.mortgagecalculator;

import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final  static byte PERCENT = 100;

    private  int  principal;
    private  float annualPercentInterestRate;
    private int years;

    public MortgageCalculator(int principal, float annualPercentInterestRate, int years) {
        this.principal = principal;
        this.annualPercentInterestRate = annualPercentInterestRate;
        this.years = years;
    }

    public  double calculateBalance(short numberOfPaymentsMade) {

        short totalNumberOfPayments = getTotalNumberOfPayments();
        float monthlyInterestRate = getMonthlyInterestRate();

        double balance = principal
                * (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1);

        return balance;
    }


    public  double calculateMortgage() {
        short numberOfPayments = getTotalNumberOfPayments();
        float monthlyInterestRate = getMonthlyInterestRate();

        double mortgage = principal
                * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));

        return mortgage;
    }

    public double[] getRemainingBalances(){
        double[] balances = new double[getTotalNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month-1] = calculateBalance(month);

        return balances;
    }


    private short getTotalNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterestRate() {
        return annualPercentInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
