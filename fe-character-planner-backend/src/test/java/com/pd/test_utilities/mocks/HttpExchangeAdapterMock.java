package com.pd.test_utilities.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pd.fe_character_planner.HttpExchangeAdapter;
import com.sun.net.httpserver.HttpExchange;
import java.util.List;
import java.util.Map;

public class HttpExchangeAdapterMock extends HttpExchangeAdapter {
  private HttpExchange exchange;
  private int responseCode = -1;
  private int responseLength = -1;
  private String responseText = "";
  private int sendHeaderCallCount = 0;
  private int sendBodyCallCount = 0;

  @Override
  public void sendHeader(HttpExchange exchange, int responseCode, int responseLength) {
    this.exchange = exchange;
    this.responseCode = responseCode;
    this.responseLength = responseLength;
    sendHeaderCallCount++;
  }

  @Override
  public void sendBody(HttpExchange exchange, String responseText) {
    this.exchange = exchange;
    this.responseText = responseText;
    sendBodyCallCount++;
  }

  public void verifyResponse(int expectedResponseCode, int expectedResponseLength, int expectedSendHeaderCallCount, Map<String, List<String>> expectedHeaders) {
    assertEquals(expectedResponseCode, responseCode);
    assertEquals(expectedResponseLength, responseLength);
    assertEquals(expectedSendHeaderCallCount, sendHeaderCallCount);
    assertEquals(expectedHeaders, exchange.getResponseHeaders());
  }

  public void verifyBody(String expectedResponseText, int expectedSendBodyCallCount) {
    assertEquals(expectedResponseText, responseText);
    assertEquals(expectedSendBodyCallCount, sendBodyCallCount);
  }

  public void verifyNoBodySent() {
    assertEquals(0, sendBodyCallCount);
  }
}
