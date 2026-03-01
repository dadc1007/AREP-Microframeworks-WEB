package com.adojos.app;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final Map<String, String> queryParams;

    public HttpRequest(URI uri) {
        this.queryParams = parseQueryParams(uri.getRawQuery());
    }

    public HttpRequest() {
        this.queryParams = new HashMap<>();
    }

    public String getValues(String varname) {
        return queryParams.get(varname);
    }

    private Map<String, String> parseQueryParams(String rawQuery) {
        Map<String, String> params = new HashMap<>();

        if (rawQuery == null || rawQuery.isEmpty()) {
            return params;
        }

        String[] pairs = rawQuery.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");

            if (keyValue.length == 2) {
                params.put(keyValue[0], keyValue[1]);
            }

        }
        return params;
    }
}
