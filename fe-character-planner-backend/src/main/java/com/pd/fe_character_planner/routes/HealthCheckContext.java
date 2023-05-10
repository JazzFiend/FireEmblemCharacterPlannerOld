package com.pd.fe_character_planner.routes;

import com.pd.fe_character_planner.HttpExchangeAdapter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

public class HealthCheckContext {
  public static final String PATH = "/api/healthCheck";

  private static final String FRONTEND_URL = "http://localhost:8081";
//  private static final String RESPONSE_TEXT = "FE Character Planner working correctly!\n";
  private static final String RESPONSE_TEXT = "Health Check Successful!\n";

  private HealthCheckContext() {}

  public static HttpHandler createHealthCheckHandler(HttpExchangeAdapter exchangeAdapter) {
    return (exchange -> {
      if (exchange.getRequestMethod().equals("GET")) {
        sendHeaders(exchangeAdapter, exchange);
        sendBody(exchangeAdapter, exchange);
      } else if(exchange.getRequestMethod().equals("OPTIONS")) {
        sendPreflightResponse(exchangeAdapter, exchange);
      } else {
        sendError(exchangeAdapter, exchange);
      }
      exchange.close();
    });
  }

  private static void sendHeaders(HttpExchangeAdapter exchangeAdapter, HttpExchange exchange) throws IOException {
    exchange.getResponseHeaders().set("Access-Control-Allow-Origin", FRONTEND_URL);
    exchangeAdapter.sendHeader(exchange, 200, RESPONSE_TEXT.getBytes().length);
  }

  private static void sendBody(HttpExchangeAdapter exchangeAdapter, HttpExchange exchange) throws IOException {
    exchangeAdapter.sendBody(exchange, RESPONSE_TEXT);
  }

  private static void sendPreflightResponse(HttpExchangeAdapter exchangeAdapter, HttpExchange exchange) throws IOException {
    exchange.getResponseHeaders().set("Connection", "keep-alive");
    exchange.getResponseHeaders().set("Access-Control-Allow-Origin", FRONTEND_URL);
    exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET");
    exchange.getResponseHeaders().set("Access-Control-Max-Age", "86400");
    exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "content-type");
    exchangeAdapter.sendHeader(exchange, 204, 0);
  }

  private static void sendError(HttpExchangeAdapter exchangeAdapter, HttpExchange exchange) throws IOException {
    exchangeAdapter.sendHeader(exchange, 405, -1);
  }
}
