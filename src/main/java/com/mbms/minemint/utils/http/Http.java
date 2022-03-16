package com.mbms.minemint.utils.http;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Http {
    private static final GsonFactory JSON_FACTORY = new GsonFactory();
    private static final HttpRequestFactory REQUEST_FACTORY = new NetHttpTransport().createRequestFactory(
            (HttpRequest request) -> request.setParser(new JsonObjectParser(JSON_FACTORY)));

    @Nullable
    public static <T> ParsedResponse<T> request(String method, String url, Class<T> responseClass, Object payload) {
        ParsedResponse<T> response;
        JsonHttpContent _payload = null;

        if (payload != null)
            _payload = new JsonHttpContent(JSON_FACTORY, payload);

        GenericUrl genericUrl = new GenericUrl(url);
        HttpRequest request;
        HttpResponse res = null;
        try {
            request = REQUEST_FACTORY.buildRequest(method, genericUrl, _payload);
            res = request.executeAsync().get();
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        if (res == null) return null;
        response = new ParsedResponse<>(res, responseClass);

        return response;
    }
}
