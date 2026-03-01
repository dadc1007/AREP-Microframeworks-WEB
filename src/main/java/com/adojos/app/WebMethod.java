package com.adojos.app;

public interface WebMethod {
    // String execute();
    String execute(HttpRequest req, HttpResponse res);
}
