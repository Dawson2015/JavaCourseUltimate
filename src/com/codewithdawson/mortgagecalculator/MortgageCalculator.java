package com.codewithdawson.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        int principal = 0;

        while(true){
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if(principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        float annualPercentInterestRate = 0F;
        while(true){
            System.out.print("Annual Interest Rate: ");
            annualPercentInterestRate = scanner.nextFloat();
            if (annualPercentInterestRate>0 && annualPercentInterestRate <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less that or equal to 30");
        }
        float monthlyInterestRate = annualPercentInterestRate/PERCENT/MONTHS_IN_YEAR;

        byte years = 0;
        while (true){
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if(years >= 1 && years <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }
        int numberOfPayments = years * MONTHS_IN_YEAR;

        //calculate the mortgage
        double mortgage = principal*((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);

    }
}
