package fr.lernejo.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ServerTest {
    @Test
    public void testServer_whenRequestHasBeenAccepted_ShouldReturnCodeStatus200() throws IOException, InterruptedException {
        Server server = new Server(8000, "localhost");
        Assertions.assertTrue(server.run());
    }

    public void testPingRequestOnServer_whenRequestHasBeenAccepted_ShouldReturnCodeStatus200() throws IOException, InterruptedException {
        Server server = new Server(8000, "localhost");
        Assertions.assertTrue(server.run());
    }
}
