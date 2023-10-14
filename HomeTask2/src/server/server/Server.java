package server.server;

import server.client.Client;
import server.client.ClientGUI;
import server.server.rep.Repository;

import java.util.ArrayList;
import java.util.List;

public class Server {

    static List<Client> clientGUIList; //объявляем список, в котором будем хранить логины всех клиентов, подклеченных к серверу
    private Repository repository;
    private ServerView serverView;
    private boolean work;

    public Server(Repository repository){
        this.repository = repository;
        serverView = new ServerWindow(this);
        clientGUIList = new ArrayList<>(); //инициализируем список
    }

    public void disconnectUser(Client client){
        clientGUIList.remove(client);
        if (client != null){
            //answerAll("Вы были отключены от сервера!");
            client.disconnect(); //этот метод находится в файле server.client.ClientGUI
        }
    }

    //если при выхове метода сервер работает, то в список клиентов добавляется логин клиента
    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientGUIList.add(client);
        //iswork = true;
        return true;
    }

    //метод, передающий историю сообщений
    public String getHistory() {
        return repository.readLog();
    }
    //метод, отправляющий всем сообщение
    public void answerAll(String text){
        for (int i = clientGUIList.size() - 1; i >= 0; i--) {
            System.out.println("Клиент " + i + " " + clientGUIList.get(i).getName());
            clientGUIList.get(i).serverAnswer(text);
        }
    }

    //метод, с помощью которого принимаем сообщения от клиентов и отправляем каждое сообщение всем клиентам
    public void message(String text){
        if (!work){
            return;
        }
        text += "";
        serverView.incomingMsg(text);
        answerAll(text);
        repository.saveInLog(text);
    }


    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }
}

