package fr.lernejo.server;

import com.sun.net.httpserver.HttpServer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServerTest {

    private HttpResponse<String> resp;

    @Test
    public void testPing() throws IOException, InterruptedException {

        Server s = new Server(8000, "localhost");
        HttpServer server = s.run();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8000/ping"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .GET()
            .build();
        resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        server.stop(1);

        int expected = HttpURLConnection.HTTP_OK;
        int result = resp.statusCode();
        Assertions.assertThat(result).as("Response should be 200 OK").isEqualTo(expected);
    }

}
