package com.conversordemonedas.conversor;

public class Conversion {
    String fromCurrency;
    String toCurrency;
    double originalAmount;
    double convertedAmount;
    double conversionRate;

    public Conversion(String fromCurrency, String toCurrency, double originalAmount,
                      double convertedAmount, double conversionRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.conversionRate = conversionRate;
    }
}
