package fr.lernejo.navy_battle;

import fr.lernejo.server.Server;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            throw new IllegalArgumentException("The program needs atleast 1 argument");
        }
        else if (args.length == 2) {
            Server newServer = new Server(Integer.parseInt(args[0]),args[1]);
            newServer.run();
        }
        else {
            Server newServer = new Server(Integer.parseInt(args[0]), "");
            newServer.run();
        }
    }
}
