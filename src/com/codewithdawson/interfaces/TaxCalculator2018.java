package com.codewithdawson.interfaces;

public class TaxCalculator2018  extends AbstractTaxCalculator{
    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax(){
        getTaxableIncome(5000,2000);
        return taxableIncome * .3;
    }
}
