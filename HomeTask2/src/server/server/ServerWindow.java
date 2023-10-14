package server.server;

import server.client.Client;
import server.client.ClientGUI;

import javax.swing.*; //импортируем фреймворк swing для возможности работы с окнами
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static server.server.Server.clientGUIList;

public class ServerWindow extends JFrame  implements ServerView { //создаем класс и наследуем его от JFrame для того, что бы можно было выводить в окно содержимое класса

    private static final int WIDTH = 555; // задаем ширину окна
    private static final int HEIGHT = 507; // задаем высоту окна
    private static final String THE_FILE = "D:\\GeekBrains\\Java Development Kit\\text.txt";
    JTextArea textArea;
    JButton btnStart, btnStop;
    JPanel panBottom;
    boolean isStart = false;
    private Server server;
    private Client client;

    public ServerWindow(Server server) {
        this.server = server;
        this.client = client;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задаем операцию, которая произойдет, когда пользователь нажмет на X(крестик).
        setSize(WIDTH, HEIGHT); //Задаем размер окна
        setLocationRelativeTo(null); //центруем окно
        setTitle("Chat client");

        createPanel();
        setResizable(true); //включаем возможность изменять размер окна

        setVisible(true); //делаем наше окно видимым
    }

    public void createPanel() {
        add(createCenter());
        add(createBottomPanel(), BorderLayout.SOUTH);
    }

    public Component createCenter() {
        textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);
        return new JScrollPane(textArea);
    }

    public Component createBottomPanel() {
        panBottom = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnStart.addActionListener(new ActionListener() { //описываем логику работы программы при нажатии на кнопку
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isWork()) {
                    incomingMsg("Server is already running"); //вызываем метод, который добавляет текст в определенном формате
                } else {

                    server.setWork(true);
                    incomingMsg("Start server"); //вызываем метод, который добавляет текст в определенном формате
                }
            }
        });
        btnStop.addActionListener(new ActionListener() { //описываем логику работы программы при нажатии на кнопку
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isStart) {
                    incomingMsg("Server was stopped"); //вызываем метод, который добавляет текст в определенном формате
                } else {
                    isStart = false;
                    for (Client client : clientGUIList) {
                        server.disconnectUser(client); //удаляем пользователя из списка
                    }
                    incomingMsg("Stop server"); //вызываем метод, который добавляет текст в определенном формате
                }
            }
        });


        panBottom.add(btnStart);
        panBottom.add(btnStop);
        return panBottom;
    }

    @Override
    public void incomingMsg(String text) {
        textArea.append(text + "\n");
    }
}


    //метод, выгружающий из файла строки истории



    //метод, сохраняющий сообщение в файл



