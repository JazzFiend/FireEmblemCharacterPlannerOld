package com.pd.fe_character_planner;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;

public class HttpExchangeAdapter {
  public void sendHeader(HttpExchange exchange, int responseCode, int responseLength) throws IOException {
    exchange.sendResponseHeaders(responseCode, responseLength);
  }

  public void sendBody(HttpExchange exchange, String responseText) throws IOException {
    OutputStream output = exchange.getResponseBody();
    output.write(responseText.getBytes());
    output.flush();
  }
}
