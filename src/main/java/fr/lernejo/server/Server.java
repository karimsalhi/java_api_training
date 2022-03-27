package fr.lernejo.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {

    final int port;
    final String url;

    public Server(int port, String url)
    {
        this.port = port;
        this.url = url;
    }

    public void run() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(this.url, this.port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new Ping());
        server.start();
    }

}
