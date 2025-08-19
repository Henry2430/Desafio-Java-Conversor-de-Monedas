package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConvertidorDeMonedas {
    private static final String API_KEY = "6b97069349a759aeff3901fa";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private final OkHttpClient client;
    private final Gson gson;

    public ConvertidorDeMonedas() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    public double convertir(String desde, String hacia, double cantidad) throws Exception {
        String url = API_URL + desde;
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new RuntimeException("Error en la API");

            String json = response.body().string();
            ExchangeRateResponse exchangeData = gson.fromJson(json, ExchangeRateResponse.class);

            Double tasa = exchangeData.getConversion_rates().get(hacia);
            if (tasa == null) throw new RuntimeException("Moneda no encontrada: " + hacia);

            return cantidad * tasa;
        }
    }
}



