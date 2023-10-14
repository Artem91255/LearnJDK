package server;

import server.client.ClientGUI;
import server.server.Server;
import server.server.ServerWindow;
import server.server.rep.Repository;
import server.server.rep.Storage;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Storage("src\\server\\server\\rep\\log.txt");

        Server server = new Server(repository);
        new ClientGUI(server);
        new ClientGUI(server);
    }
}