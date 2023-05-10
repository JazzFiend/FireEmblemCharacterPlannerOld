package com.pd.fe_character_planner.routes;

import static org.junit.jupiter.api.Assertions.fail;

import com.pd.test_utilities.mocks.HttpExchangeAdapterMock;
import com.pd.test_utilities.HttpExchangeMockFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpHealthCheckContextTest {
  HttpExchangeAdapterMock exchangeMock;
  @BeforeEach
  void setup() {
    exchangeMock = new HttpExchangeAdapterMock();
  }

  @Test
  void notFoundError() {
    try {
      HealthCheckContext.createHealthCheckHandler(exchangeMock)
          .handle(HttpExchangeMockFactory.createErrorCase());
    } catch (IOException ex) {
      fail(ex.getMessage());
    }

    exchangeMock.verifyResponse(405, -1, 1, new HashMap<>());
    exchangeMock.verifyNoBodySent();
  }

  @Test
  void checkPreflightHeaders() {
    Map<String, List<String>> responseHeaders = new HashMap<>();
    responseHeaders.put("Connection", List.of("keep-alive"));
    responseHeaders.put("Access-Control-Allow-Origin", List.of("http://localhost:8081"));
    responseHeaders.put("Access-Control-Allow-Methods", List.of("GET"));
    responseHeaders.put("Access-Control-Max-Age", List.of("86400"));
    responseHeaders.put("Access-Control-Allow-Headers", List.of("content-type"));

    try {
      HealthCheckContext.createHealthCheckHandler(exchangeMock)
          .handle(HttpExchangeMockFactory.createPreflightCase());
    } catch (IOException ex) {
      fail(ex.getMessage());
    }

    exchangeMock.verifyResponse(204, 0, 1, responseHeaders);
    exchangeMock.verifyNoBodySent();
  }

  @Test
  void getHealthCheck() {
    Map<String, List<String>> responseHeaders = new HashMap<>();
    responseHeaders.put("Access-Control-Allow-Origin", List.of("http://localhost:8081"));
    String expectedResponse = "FE Character Planner working correctly!\n";
    try {
      HealthCheckContext.createHealthCheckHandler(exchangeMock).handle(HttpExchangeMockFactory.createStandardCase());
    } catch (IOException ex) {
      fail(ex.getMessage());
    }

    exchangeMock.verifyResponse(200, expectedResponse.length(), 1, responseHeaders);
    exchangeMock.verifyBody(expectedResponse, 1);
  }
}
