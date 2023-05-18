package com.pd.fe_character_planner;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

public class FeCharacterPlannerMain {
  public static final int PORT = 8080;

  public static void main(String[] args) throws IOException {
    HttpServer server = ServerCreator.createServer(new HttpExchangeAdapter(), PORT);
    server.start();
  }
}
