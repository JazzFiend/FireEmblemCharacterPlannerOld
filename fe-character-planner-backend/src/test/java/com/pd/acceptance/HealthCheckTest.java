package com.pd.acceptance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.pd.fe_character_planner.FeCharacterPlannerMain;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.Test;

class HealthCheckTest {
	@Test
	void healthCheck() {
		HttpResponse<String> response = null;
		try {
			startServer();
			response = requestHealthCheck();
		} catch (IOException | InterruptedException ex) {
			fail(ex.getMessage());
		}
		assertEquals("FE Character Planner working correctly!\n", response.body());
	}

	private static void startServer() throws IOException {
		String[] args = {};
		FeCharacterPlannerMain.main(args);
	}

	private static HttpResponse<String> requestHealthCheck()
			throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/api/healthCheck/"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();

		return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	}
}
