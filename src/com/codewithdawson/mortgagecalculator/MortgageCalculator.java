package com.codewithdawson.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        int principal = (int) readNumber("principal: ", 1_000, 1_000_000);
//        while(true){
//            System.out.print("Principal ($1K - $1M): ");
//            principal = scanner.nextInt();
//            if(principal >= 1_000 && principal <= 1_000_000)
//                break;
//            System.out.println("Enter a number between 1,000 and 1,000,000.");
//        }

        float annualPercentInterestRate = (float) readNumber("Annual Interest Rate: ", 1,30);
//        while(true){
//            System.out.print("Annual Interest Rate: ");
//            annualPercentInterestRate = scanner.nextFloat();
//            if (annualPercentInterestRate>0 && annualPercentInterestRate <= 30)
//                break;
//            System.out.println("Enter a value greater than 0 and less that or equal to 30");
//        }

        byte years = (byte)readNumber("Period (Years): ",1,30);
//        while (true){
//            System.out.print("Period (Years): ");
//            years = scanner.nextByte();
//            if(years >= 1 && years <= 30)
//                break;
//            System.out.println("Enter a value between 1 and 30");
//        }

        //calculate the mortgage
        double mortgage = calculateMortgage(principal,annualPercentInterestRate,years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);
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
    public static double calculateMortgage(
            int principal,
            float annualPercentInterestRate,
            byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayments =(short) (years * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualPercentInterestRate/PERCENT/MONTHS_IN_YEAR;

        double mortgage = principal
                *((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                /(Math.pow(1+monthlyInterestRate,numberOfPayments)-1));

        return mortgage;
    }
}
