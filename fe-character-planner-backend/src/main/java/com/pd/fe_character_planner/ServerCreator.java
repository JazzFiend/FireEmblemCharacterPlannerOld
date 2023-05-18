package com.pd.fe_character_planner;

import com.pd.fe_character_planner.routes.HealthCheckContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerCreator {
  private ServerCreator() {}

  public static HttpServer createServer(HttpExchangeAdapter exchangeAdapter, int port) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext(HealthCheckContext.PATH, HealthCheckContext.createHealthCheckHandler(exchangeAdapter));
    server.setExecutor(null);
    return server;
  }
}
