package com.pd.fe_character_planner.boundaries;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.pd.fe_character_planner.ServerCreator;
import com.pd.test_utilities.mocks.HttpExchangeAdapterMock;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.junit.jupiter.api.Test;

class ServerCreatorTest {
  public static final int PORT = 1234;

  @Test
  void createServerTest() {
    HttpServer server = null;
    try {
      server = ServerCreator.createServer(new HttpExchangeAdapterMock(), PORT);
    } catch (IOException ex) {
      fail(ex.getMessage());
    }
    assertEquals(new InetSocketAddress("0:0:0:0:0:0:0:0", PORT), server.getAddress());
    assertNull(server.getExecutor());
  }
}
