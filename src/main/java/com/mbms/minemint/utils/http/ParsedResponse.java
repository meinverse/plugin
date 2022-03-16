package com.mbms.minemint.utils.http;

import com.google.api.client.http.HttpResponse;

import java.io.IOException;

public record ParsedResponse<T>(HttpResponse res, Class<T> responseClass) {
    public T getParsedJsonData() {
        try {
            return res.parseAs(responseClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getParsedStringData() {
        try {
            return res.parseAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getStatusCode() {
        return res.getStatusCode();
    }

    public String getStatusMessage() {
        return res.getStatusMessage();
    }

    public boolean getIsSuccess() {
        return res.isSuccessStatusCode();
    }

    public HttpResponse getRes() {
        return res;
    }
}
