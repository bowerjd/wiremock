package com.github.tomakehurst.wiremock.http.ssl;

import javax.net.ssl.SSLEngine;
import java.net.Socket;
import java.security.cert.X509Certificate;

public class TrustEverythingStrategy implements TrustStrategy {
    @Override
    public boolean isTrusted(X509Certificate[] chain, String authType) {
        return true;
    }

    @Override
    public boolean isTrusted(X509Certificate[] chain, String authType, Socket socket) {
        return true;
    }

    @Override
    public boolean isTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {
        return true;
    }
}
