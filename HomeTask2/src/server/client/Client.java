package server.client;

import server.server.Server;
import server.server.ServerWindow;

public class Client {
    private String name;
    private ClientView clientView;
    private ServerWindow server;
    private boolean connected;
    private Server serverNew;

    public Client (ClientView clientView, Server serverNew) {
        this.clientView = clientView;
        this.serverNew = serverNew;
    }

    public boolean connectToServer(String name){
        this.name = name;
        if (serverNew.connectUser(this)){
            connected = true;
            printText("Вы успешно подключились!\n");

            String log = serverNew.getHistory();
            if (log != null){
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }

    }
    //мы посылаем
    public void sendMessage(String message){
        if (connected) {
            if (!message.isEmpty()) {
                serverNew.message(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }
    //нам посылают
    public void serverAnswer(String answer){
        printText(answer);
    }
    public void disconnect(){
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            serverNew.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }

    public String getName(){
        return name;
    }

    private void printText(String text){
        clientView.showMessage(text);
    }
}
