package com.conversordemonedas.conversor;

import com.conversordemonedas.conversor.CurrencyConverter;

public class Principal {
    public static void main(String[] args) {
        try {
            // API Key
            String apiKey = "df56c26752b842fe9c76d333";
            CurrencyConverter converter = new CurrencyConverter(apiKey);
            converter.convertCurrency();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
