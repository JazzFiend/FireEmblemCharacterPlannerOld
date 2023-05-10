package com.pd.test_utilities;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class HttpExchangeMockFactory {
  public static HttpExchange createErrorCase() { return new HttpExchangeStubErrorCase(); }
  public static HttpExchange createPreflightCase() { return new HttpExchangeStubPreflightCase(); }
  public static HttpExchange createStandardCase() { return new HttpExchangeStubStandardCase(); }

  private static class HttpExchangeStubErrorCase extends HttpExchangeDummy {
    @Override
    public String getRequestMethod() {
      return "ERROR";
    }
  }

  private static class HttpExchangeStubPreflightCase extends HttpExchangeDummy {
    @Override
    public String getRequestMethod() {
      return "OPTIONS";
    }
  }

  private static class HttpExchangeStubStandardCase extends HttpExchangeDummy {
    @Override
    public String getRequestMethod() {
      return "GET";
    }
  }



  private static class HttpExchangeDummy extends HttpExchange {
    private final Headers responseHeaders = new Headers();
    @Override
    public Headers getRequestHeaders() {
      return null;
    }

    @Override
    public Headers getResponseHeaders() {
      return responseHeaders;
    }

    @Override
    public URI getRequestURI() {
      return null;
    }

    @Override
    public String getRequestMethod() {
      return null;
    }

    @Override
    public HttpContext getHttpContext() {
      return null;
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getRequestBody() {
      return null;
    }

    @Override
    public OutputStream getResponseBody() {
      return null;
    }

    @Override
    public void sendResponseHeaders(int rCode, long responseLength) throws IOException {

    }

    @Override
    public InetSocketAddress getRemoteAddress() {
      return null;
    }

    @Override
    public int getResponseCode() {
      return 0;
    }

    @Override
    public InetSocketAddress getLocalAddress() {
      return null;
    }

    @Override
    public String getProtocol() {
      return null;
    }

    @Override
    public Object getAttribute(String name) {
      return null;
    }

    @Override
    public void setAttribute(String name, Object value) {

    }

    @Override
    public void setStreams(InputStream i, OutputStream o) {

    }

    @Override
    public HttpPrincipal getPrincipal() {
      return null;
    }
  }


}
