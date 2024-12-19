package com.conversor.monedas;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConvertidor  {

    public String busquedaMoneda(String tipoMonedaOrigen, String tipoMonedaCambio, double valorIngresado) throws IOException {

        String url_str = "https://v6.exchangerate-api.com/v6/82e21f901474c7f30c2eed27/pair/" + tipoMonedaOrigen + "/" + tipoMonedaCambio + "/" +valorIngresado;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        return jsonobj.get("conversion_result").getAsString();
    }

}
