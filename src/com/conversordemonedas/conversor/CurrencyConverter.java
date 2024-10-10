package com.conversordemonedas.conversor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private Map<String, Double> rates;
    private List<Conversion> conversiones;

    public CurrencyConverter(String apiKey) throws Exception {
        // Inicializar cliente y obtener tasas de cambio
        String uriExchangeApi = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uriExchangeApi)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Deserializar el JSON a un objeto
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(response.body(), ExchangeRateResponse.class);
        rates = exchangeRateResponse.getConversionRates();
        conversiones = new ArrayList<>();
    }

    public void showAvailableCurrencies() {
        System.out.println("Monedas disponibles:");
        System.out.println("---------------------");
        rates.keySet().stream()
                .sorted()
                .forEach(currency -> System.out.printf("%-4s ", currency));
        System.out.println();  // Salto de línea al final
        System.out.println("---------------------");
    }

    public void convertCurrency() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            showAvailableCurrencies();

            // Elegir la moneda de origen
            System.out.print("Ingrese el código de la moneda de origen (por ejemplo, USD, EUR): ");
            String fromCurrency = scanner.nextLine().toUpperCase();

            if (!rates.containsKey(fromCurrency)) {
                System.out.println("Moneda de origen no válida.");
                continue;
            }

            // Elegir la moneda de destino
            System.out.print("Ingrese el código de la moneda a la que desea convertir: ");
            String toCurrency = scanner.nextLine().toUpperCase();

            if (!rates.containsKey(toCurrency)) {
                System.out.println("Moneda de destino no válida.");
                continue;
            }

            // Solicitar cantidad en la moneda de origen
            System.out.print("Ingrese la cantidad en " + fromCurrency + " que desea convertir: ");
            double amountInFromCurrency = scanner.nextDouble();

            // Realizar la conversión
            double conversionRate = rates.get(toCurrency) / rates.get(fromCurrency);
            double convertedAmount = amountInFromCurrency * conversionRate;

            // Redondear el resultado
            convertedAmount = Math.round(convertedAmount * 100.0) / 100.0;

            System.out.println(amountInFromCurrency + " " + fromCurrency + " equivale a " + convertedAmount + " " + toCurrency);

            // Guardar la conversión
            conversiones.add(new Conversion(fromCurrency, toCurrency, amountInFromCurrency, convertedAmount, conversionRate));

            // Limpiar buffer de Scanner
            scanner.nextLine();

            // Preguntar si desea realizar otra conversión
            System.out.print("¿Desea realizar otra conversión? (si/no): ");
            String respuesta = scanner.nextLine().toLowerCase();
            continuar = respuesta.equals("si");
        }

        // Serializar la lista de conversiones a un archivo JSON
        saveConversionsToFile();
    }

    private void saveConversionsToFile() {
        try (FileWriter writer = new FileWriter("conversiones.json")) {
            // Crear una instancia de Gson con pretty printing
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Serializar la lista de conversiones a JSON
            gson.toJson(conversiones, writer);

            System.out.println("Las conversiones se han guardado en 'conversiones.json'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
