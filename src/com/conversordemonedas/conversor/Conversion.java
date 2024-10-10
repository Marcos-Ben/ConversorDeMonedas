package com.conversordemonedas.conversor;

public class Conversion {
    private String fromCurrency;
    private String toCurrency;
    private double originalAmount;
    private double convertedAmount;
    private double conversionRate;

    public Conversion(String fromCurrency, String toCurrency, double originalAmount,
                      double convertedAmount, double conversionRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.conversionRate = conversionRate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public double getConversionRate() {
        return conversionRate;
    }
}
