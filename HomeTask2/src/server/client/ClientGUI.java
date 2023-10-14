package server.client;

import server.server.ServerWindow;
import server.server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientGUI extends JFrame implements ClientView {

    private static final int WIDTH = 600; // задаем ширину окна
    private static final int HEIGHT = 200; // задаем высоту окна
    private static final String THE_FILE = "D:\\GeekBrains\\Java Development Kit\\text.txt";
    JTextField TFipAddress, TFPort, TFMessage, TFLogin;
    JPasswordField TFPassword;
    JTextArea TAMessageArea;
    JPanel panTop1, panBottom;
    JButton btnLogin, btnSend, btnEmpty;
   //String name;
   // boolean connected; //флажок, показывающий, подключен ли клиент или нет
    //private ServerWindow server;
    private Client client;
   // private Server server;

    public ClientGUI(Server server) {
        this.client = new Client(this, server);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задаем операцию, которая произойдет, когда пользователь нажмет на X(крестик).
        setSize(WIDTH, HEIGHT); //Задаем размер окна
        //setLocationRelativeTo(null); //центруем окно
        setTitle("Chat client");
        //setLocation(server.getX() - 500, server.getY());
        setResizable(false); //выключаем возможность изменять размер окна

        createPanel();
        setVisible(true); //делаем наше окно видимым
    }

    public void createPanel() {
        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenter());
        add(createBottomPanel(), BorderLayout.SOUTH);

    }
    public Component createTopPanel(){
        panTop1 = new JPanel(new GridLayout(2, 3));
        TFipAddress = new JTextField("127.0.0.1");
        TFPort = new JTextField(("5050"));
        TFLogin = new JTextField("login");
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() { //логика работы программы при нажатии на кнопку логин
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });
        TFPassword = new JPasswordField("******");
        TFMessage = new JTextField();
        TAMessageArea = new JTextArea();
        btnEmpty = new JButton();
        btnEmpty.setEnabled(false);

        panTop1.add(TFipAddress);
        panTop1.add(TFPort);
        panTop1.add(btnEmpty);
        panTop1.add(TFLogin);
        panTop1.add(TFPassword);
        panTop1.add(btnLogin);
        return panTop1;

    }
    public Component createCenter(){
    TAMessageArea = new JTextArea();
    TAMessageArea.setEnabled(false);
    TAMessageArea.setLineWrap(true);
    TAMessageArea.setWrapStyleWord(true);
    TAMessageArea.setSelectedTextColor(Color.BLACK);
    setFont(new Font("Dialog", Font.PLAIN, 14));
    add(TAMessageArea,BorderLayout.CENTER);
    return new JScrollPane(TAMessageArea);
}
    public Component createBottomPanel(){
        panBottom = new JPanel(new GridLayout(1, 2));
        TFMessage = new JTextField();
        TFMessage.addKeyListener(new KeyAdapter() { //отправка сообщения по нажатию на enter
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    sendMessage();
                }
            }
        });
        btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        panBottom.add(TFMessage);
        panBottom.add(btnSend, BorderLayout.EAST);
        return panBottom;

}

    public void sendMessage(){
        client.sendMessage(TFMessage.getText());
        TFMessage.setText("");

    }
    private void connectToServer() {
        if (client.connectToServer(TFLogin.getText())){
            hideHeaderPanel(false);
        }
    }
    public void appendTolog(String text){
        TAMessageArea.append(text + "\n");
    }
    public void disconnectFromServer() {
        hideHeaderPanel(true);
        client.disconnect();
    }
    private void hideHeaderPanel(boolean visible){
        panTop1.setVisible(visible);
    }
    //public void answer(String text){
//        appendTolog(text);
//    }

    @Override
    public void showMessage(String text){
        appendTolog(text);
    }
}

